package model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class Procedure implements CaseComponent{
	
	private String name;
	private String disease;
	private int percentOfUse;
	
	public Procedure(String name, String disease, int percentOfUse) {
		super();
		this.name = name;
		this.disease = disease;
		this.percentOfUse = percentOfUse;
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

	public int getPercentOfUse() {
		return percentOfUse;
	}

	public void setPercentOfUse(int percentOfUse) {
		this.percentOfUse = percentOfUse;
	}

	@Override
	public String toString() {
		return "Procedure [name=" + name + ", disease=" + disease
				+ ", percentOfUse=" + percentOfUse + "]";
	}	
}
