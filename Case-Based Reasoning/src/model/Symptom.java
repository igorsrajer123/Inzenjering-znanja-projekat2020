package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Symptom implements CaseComponent{

	private String name;
	private String diagnose;
	private String age;

	public Symptom(String name, String diagnose, String age){
		this.name = name;
		this.diagnose = diagnose;
		this.age = age;
	}
	
	public Symptom(){
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiagnose() {
		return diagnose;
	}

	public void setDiagnose(String diagnose) {
		this.diagnose = diagnose;
	}
	
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}	
}
