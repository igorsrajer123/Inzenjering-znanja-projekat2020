package connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import model.Medication;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class MedicationConnector implements Connector{

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
				
				//parsiranje medications.csv fajla
				Medication medication = new Medication();
				
				medication.setName(values[5]);
				medication.setDisease(values[4]);
				medication.setSymptom(values[3]);
				//medication.setSymptom(Arrays.asList(values[3]));
				//medication.setPercentOfUse(Integer.parseInt(values[2]));
				
				cbrCase.setDescription(medication);
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
