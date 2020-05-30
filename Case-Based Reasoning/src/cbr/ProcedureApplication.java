package cbr;

import java.util.Collection;
import model.Procedure;
import connector.ProcedureConnector;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.EqualsStringIgnoreCase;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class ProcedureApplication implements StandardCBRApplication{

Connector _connector;  /** Connector object */
	
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public void configure() throws ExecutionException {
		_connector =  new ProcedureConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
	
		simConfig.addMapping(new Attribute("disease", Procedure.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("name", Procedure.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("percentOfUse", Procedure.class), new Interval(20));
	}
	
	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 4);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval)
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		for (CBRCase c: cases)
			System.out.println(c.getDescription());
		return _caseBase;
	}
	
	public static void main(String[] args) {
		StandardCBRApplication recommender = new ProcedureApplication();
		
		try{
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			
			Procedure procedure = new Procedure();
			
			//symptom.setDiagnose(Arrays.asList("asthma"));
			procedure.setName("plain_x_ray");
			procedure.setDisease("asthma");
			procedure.setPercentOfUse(95);
			
			query.setDescription(procedure);

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
