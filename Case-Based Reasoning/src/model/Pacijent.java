package model;

import java.io.Serializable;

public class Pacijent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ime;
	private String prz;
	private int god;
	private String simp;
	private String bolest;
	private String lek;
	private String procedura;
	
	public Pacijent(String ime, String prz, int god, String simp,
			String bolest, String lek, String procedura) {
		super();
		this.ime = ime;
		this.prz = prz;
		this.god = god;
		this.simp = simp;
		this.bolest = bolest;
		this.lek = lek;
		this.procedura = procedura;
	}
	
	public Pacijent() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrz() {
		return prz;
	}
	public void setPrz(String prz) {
		this.prz = prz;
	}
	public int getGod() {
		return god;
	}
	public void setGod(int god) {
		this.god = god;
	}
	public String getSimp() {
		return simp;
	}
	public void setSimp(String simp) {
		this.simp = simp;
	}
	public String getBolest() {
		return bolest;
	}
	public void setBolest(String bolest) {
		this.bolest = bolest;
	}
	public String getLek() {
		return lek;
	}
	public void setLek(String lek) {
		this.lek = lek;
	}
	public String getProcedura() {
		return procedura;
	}
	public void setProcedura(String procedura) {
		this.procedura = procedura;
	}
	
	@Override
	public String toString() {
		return "Pacijent [ime=" + ime + ", prz=" + prz + ", god=" + god
				+ ", simp=" + simp + ", bolest=" + bolest + ", lek=" + lek
				+ ", procedura=" + procedura + "]";
	}
}
