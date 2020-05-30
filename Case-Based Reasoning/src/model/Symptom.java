package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Symptom implements CaseComponent{

	private String name;
	private String diagnose;
	private int percentOfDiagnose;
	
	public Symptom(String name, String diagnose, int percent){
		this.name = name;
		this.diagnose = diagnose;
		this.percentOfDiagnose = percent;
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

	public int getPercentOfDiagnose() {
		return percentOfDiagnose;
	}

	public void setPercentOfDiagnose(int percentOfDiagnose) {
		this.percentOfDiagnose = percentOfDiagnose;
	}

	@Override
	public String toString() {
		return "Symptom [name=" + name + ", diagnose=" + diagnose
				+ ", percentOfDiagnose=" + percentOfDiagnose + "]";
	}
	
	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
	}	
}
