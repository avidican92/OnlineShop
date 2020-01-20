package com.fasttrackit.pojo;

public class Finantare {
	
	private int id;
	private String nume;
	private String bancaEmitenta;
	private byte nrRate;
	private String categorieProduse;
	private Boolean campanie;

	public Finantare(int id, String nume, String bancaEmitenta, byte nrRate, String categorieProduse, Boolean campanie) {
		this.id = id;
		this.nume = nume;
		this.bancaEmitenta = bancaEmitenta;
		this.nrRate = nrRate;
		this.categorieProduse = categorieProduse;
		this.campanie = campanie;
	}
	
	public Finantare() {
		
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
	
	public void setBancaEmitenta(String bancaEmitenta) {
		this.bancaEmitenta = bancaEmitenta;
	}
	
	public String getBancaEmitenta() {
		return bancaEmitenta;
	}
	
	public void setNrRate(byte nrRate) {
		this.nrRate = nrRate;
	}
	
	public byte getNrRate() {
		return nrRate;
	}
	
	public void setCategorieProduse(String categorieProduse) {
		this.categorieProduse = categorieProduse;
	}
	
	public String getCategorieProduse() {
		return categorieProduse;
	}
	
	public void setCampanie(Boolean campanie) {
		this.campanie = campanie;
	}
	
	public Boolean getCampanie() {
		return campanie;
	}
}