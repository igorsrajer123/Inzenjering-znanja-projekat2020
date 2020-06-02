package model;

import java.util.List;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Disease implements CaseComponent{

	private String disease;
	private String symptom;
	private int age;
	
	public Disease() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Disease(String symptom, int age){
		this.age = age;
		this.symptom = symptom;
	}
	
	public Disease(String disease, String symptoms, int age) {
		super();
		this.disease = disease;
		this.symptom = symptom;
		this.age = age;
	}

	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	
	@Override
	public String toString() {
		return "Disease [disease=" + disease + ", symptom=" + symptom
				+ ", age=" + age + "]";
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}	
}
