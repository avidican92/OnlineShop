package com.fasttrackit.pojo;

public class Produse {

	private int id;
	private String codProduse;
	private String nume;
	private String brand;
	private String categorie;
	private int stoc;
	private Double pret;
	
	public Produse(int id, String codProduse, String nume, String brand, String categorie, int stoc,double pret) {
		this.id = id;
		this.codProduse = codProduse;
		this.nume = nume;
		this.brand = brand;
		this.categorie = categorie;
		this.stoc = stoc;
		this.pret = pret;
	}
	
	public Produse() {
		//Constructor fara parametrii
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCodProduse(String codProduse) {
		this.codProduse = codProduse;
	}
	
	public String getCodProduse(){
		return codProduse;
	}
	
	public void setNume(String nume) {
		this.nume = nume;
	}
	
	public String getNume() {
		return nume;
	}
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getBrand() {
		return brand;
	}
	
	
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return categorie;
	}
	
	public void setStoc(int stoc) {
		this.stoc = stoc;
	}
	
	public int getStoc() {
		return stoc;
	}
	
	public void setPret(double pret) {
		this.pret = pret;
	}
	
	public Double getPret() {
		return pret;
	}
	
}
