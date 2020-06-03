package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Medication implements CaseComponent{
	private String name;
	private String disease;
	private String symptom;
	
	public Medication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Medication(String name, String disease, String symptom) {
		super();
		this.name = name;
		this.disease = disease;
		this.symptom = symptom;
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
	
	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	@Override
	public String toString() {
		return "Medication [symptom=" + symptom + ", disease=" + disease + ", name=" + name + "]";
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
}
