package cbr;

import java.util.ArrayList;
import java.util.Collection;



import model.Medication;
import connector.MedicationConnector;
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
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class MedicationApplication implements StandardCBRApplication{

	Connector _connector;  /** Connector object */
	
	CBRCaseBase _caseBase;  /** CaseBase object */

	NNConfig simConfig;  /** KNN configuration */
	
	public static ArrayList<String> aaa;
	
	public void configure() throws ExecutionException {
		_connector =  new MedicationConnector();
		
		_caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization
		
		aaa = new ArrayList<String>();
		
		simConfig = new NNConfig(); // KNN configuration
		simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average
	
		simConfig.addMapping(new Attribute("disease", Medication.class), new EqualsStringIgnoreCase());
		//simConfig.addMapping(new Attribute("name", Medication.class), new EqualsStringIgnoreCase());
		simConfig.addMapping(new Attribute("symptom", Medication.class), new EqualsStringIgnoreCase());
	}
	
	public void cycle(CBRQuery query) throws ExecutionException {
		Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
		eval = SelectCases.selectTopKRR(eval, 4);
		System.out.println("Retrieved cases:");
		for (RetrievalResult nse : eval){
			System.out.println(nse.get_case().getDescription() + " -> " + nse.getEval());
			String s = nse.get_case().getDescription().toString();
			aaa.add(s);
		}
	}

	public void postCycle() throws ExecutionException {
		
	}

	public CBRCaseBase preCycle() throws ExecutionException {
		_caseBase.init(_connector);
		java.util.Collection<CBRCase> cases = _caseBase.getCases();
		//for (CBRCase c: cases)
			//System.out.println(c.getDescription());			
		return _caseBase;
	}
	
	public void runMedicationApp(String n, String d, String s){
		StandardCBRApplication recommender = new MedicationApplication();
		
		try{
			recommender.configure();

			recommender.preCycle();

			CBRQuery query = new CBRQuery();
			
			Medication medication = new Medication();
			
			//symptom.setDiagnose(Arrays.asList("asthma"));
			medication.setName(n);
			medication.setDisease(d);
			medication.setSymptom(s);
			
			query.setDescription(medication);

			recommender.cycle(query);

			recommender.postCycle();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
