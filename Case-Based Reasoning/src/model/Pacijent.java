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
	private String pol;
	private String pusac;
	private String sportista;
	
	public Pacijent(String ime, String prz, int god, String simp,
			String bolest, String lek, String procedura, String pol, String pusac, String sportista) {
		super();
		this.ime = ime;
		this.prz = prz;
		this.god = god;
		this.simp = simp;
		this.bolest = bolest;
		this.lek = lek;
		this.procedura = procedura;
		this.pol = pol;
		this.pusac = pusac;
		this.sportista = sportista;
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
		return "Pacijent [ime=" + ime + ", prz=" + prz + ", god=" + god + ", simp=" + simp + ", bolest=" + bolest
				+ ", lek=" + lek + ", procedura=" + procedura + ", pol=" + pol + ", pusac=" + pusac + ", sportista="
				+ sportista + "]";
	}
}
