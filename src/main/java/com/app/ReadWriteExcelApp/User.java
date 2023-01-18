package com.app.ReadWriteExcelApp;


public class User {
	
	private String Nume;
	private String Prenume;
	private String adresa;
	private String email;
	
	
	public User() {
		super();
	}
	public User(String Nume, String Prenume, String adresa, String email) {
		super();
		this.Nume = Nume;
		this.Prenume = Prenume;
		this.adresa = adresa;
		this.email = email;
	}
	public String getNume() {
		return Nume;
	}
	public void setNume(String Nume) {
		this.Nume = Nume;
	}
	public String getPrenume() {
		return Prenume;
	}
	public void setPrenume(String Prenume) {
		this.Prenume = Prenume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [Numele=" + Nume + ", Prenumele=" + Prenume + ", address=" + adresa + ", email=" + email
				+ "]";
	}
	
	

}
