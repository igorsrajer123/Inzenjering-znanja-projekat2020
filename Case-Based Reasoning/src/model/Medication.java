package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Medication implements CaseComponent{
	private String name;
	private String disease;
	private List<String> symptoms;
	
	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Medication(String name, String disease, List<String> symptoms) {
		super();
		this.name = name;
		this.disease = disease;
		this.symptoms = symptoms;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	public List<String> getSymptom() {
		return symptoms;
	}

	public void setSymptom(List<String> symptoms) {
		this.symptoms = symptoms;
	}

	@Override
	public String toString() {
		return "Medication [symptom=" + symptoms + ", disease=" + disease + ", name=" + name + "]";
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
}
