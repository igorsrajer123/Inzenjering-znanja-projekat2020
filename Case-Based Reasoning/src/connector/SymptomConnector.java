package connector;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import model.Symptom;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class SymptomConnector implements Connector{
	
	@Override
	public Collection<CBRCase> retrieveAllCases() {
		LinkedList<CBRCase> cases = new LinkedList<CBRCase>();
		
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile("data/symptoms.csv")));
			
			if (br == null)
				throw new Exception("Error opening file");

			String line = "";
			while ((line = br.readLine()) != null) {
				if (line.startsWith("#") || (line.length() == 0))
					continue;
				String[] values = line.split(";");

				CBRCase cbrCase = new CBRCase();
				
				//parsiranje simptomi.csv fajla
				Symptom symptom = new Symptom();
				
				symptom.setName(values[0]);				
				symptom.setDiagnose(values[1]);
				symptom.setPercentOfDiagnose(Integer.parseInt(values[2]));
				//symptom.setDiagnose(Arrays.asList(dijagnoza.split(" ")));
				
				cbrCase.setDescription(symptom);
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
