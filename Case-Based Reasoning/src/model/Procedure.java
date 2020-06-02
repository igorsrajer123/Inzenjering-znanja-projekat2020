package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Procedure implements CaseComponent{
	
	private String name;
	private String disease;
	
	
	public Procedure(String name, String disease) {
		super();
		this.name = name;
		this.disease = disease;
	}
	
	public Procedure() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Attribute getIdAttribute() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String toString() {
		return "Procedure [name=" + name + ", disease=" + disease
				+"]";
	}	
}
