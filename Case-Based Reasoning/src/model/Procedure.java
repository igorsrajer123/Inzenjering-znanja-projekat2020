package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Procedure implements CaseComponent{
	
	private String name;
	private String disease;
	private String medication;
	private int age;
	private String symptom;
		
	public Procedure(String name, String disease, String medication,
			int age, String symptom) {
		super();
		this.name = name;
		this.disease = disease;
		this.medication = medication;
		this.age = age;
		this.symptom = symptom;
	}

	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getMedication() {
		return medication;
	}

	public void setMedication(String medication) {
		this.medication = medication;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return "Procedure [name=" + name + ", disease=" + disease
				+ ", medication=" + medication + ", age=" + age + ", symptom="
				+ symptom + "]";
	}
}
