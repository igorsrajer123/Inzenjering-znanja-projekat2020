package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import model.Disease;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class DiseaseConnector implements Connector{

	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/podaci.csv")));
			
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();
				
				//parsiranje podaci.csv fajla
				Disease disease = new Disease();
				
				disease.setDisease(values[4]);
				disease.setAge(Integer.parseInt(values[2]));
				//disease.setSymptoms(Arrays.asList(values[3]));
				disease.setSymptom(values[3]);
				disease.setPol(values[7]);
				disease.setPusac(values[8]);
				disease.setSportista(values[9]);
				
				cbrCase.setDescription(disease);
				cases.add(cbrCase);				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cases;
	}
	
	@Override
	public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
		return null;
	}

	@Override
	public void storeCases(Collection<CBRCase> arg0) {
	}
	
	@Override
	public void close() {
	}

	@Override
	public void deleteCases(Collection<CBRCase> arg0) {
	}

	@Override
	public void initFromXMLfile(URL arg0) throws InitializingException {
	}
}
