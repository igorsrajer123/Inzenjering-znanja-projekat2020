package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Disease implements CaseComponent{

	private String disease;
	private String symptom;
	private int age;
	private String pol;
	private String pusac;
	private String sportista;
	
	public Disease() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Disease(String symptom, int age){
		this.age = age;
		this.symptom = symptom;
	}
	
	public Disease(String disease, String symptom, int age) {
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
	
	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getPusac() {
		return pusac;
	}

	public void setPusac(String pusac) {
		this.pusac = pusac;
	}

	public String getSportista() {
		return sportista;
	}

	public void setSportista(String sportista) {
		this.sportista = sportista;
	}

	@Override
	public String toString() {
		return "Disease [disease=" + disease + ", symptom=" + symptom + ", age=" + age + ", pol=" + pol + ", pusac="
				+ pusac + ", sportista=" + sportista + "]";
	}	
	
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}
}
