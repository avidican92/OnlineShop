package com.fasttrackit.pojo;

public class Magazine {
	
	private int id;
	private String nume;
	private Boolean easybox;
	private String adresa;
	private String program;
	private String telefon;

	
	public Magazine(int id, String nume, Boolean easybox, String adresa, String program, String telefon) {
		this.id = id;
		this.nume = nume;
		this.easybox = easybox;
		this.adresa = adresa;
		this.program = program;
		this.telefon = telefon;
	}
	
	public Magazine() {
		
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setEasybox(Boolean easybox) {
		this.easybox = easybox;
	}
	
	public Boolean getEasybox() {
		return easybox;
	}
	
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	
	public String getAdresa() {
		return adresa;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getProgram() {
		return program;
	}

	
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	public String getTelefon() {
		return telefon;
	}
}
