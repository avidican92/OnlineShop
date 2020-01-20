package com.fasttrackit.pojo;

public class Branduri {
	private int id;
	private String nume;
	private String categorie;
	private String website;
	private String taraProvenienta;
	
	public Branduri(int id, String nume, String categorie, String website, String taraProvenienta) {
		this.id = id;
		this.nume = nume;
		this.categorie = categorie;
		this.website = website;
		this.taraProvenienta = taraProvenienta;
	}
	
	public Branduri() {
	}

	public void setId(int id) {
	this.id=id;
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
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public void setWebsite(String website) {
		this.website = website;
	}
	
	public String getWebsite() {
		return website;
	}
	
	public void setTaraProvenienta(String taraProvenienta) {
		this.taraProvenienta = taraProvenienta;
	}
	
	public String getTaraProvenienta() {
		return taraProvenienta;
	}
}