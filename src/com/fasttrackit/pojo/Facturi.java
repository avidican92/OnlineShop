package com.fasttrackit.pojo;

public class Facturi {
private int id;
private String codProdus;
private String numeProdus;
private String brand;
private String numeMagazin;
private double pret;
private String numeClient;
private int nrFactura;
private String data;
private int cantitate;
private String metodaPlata;


public Facturi() {
	
}

public Facturi(int id, String codProdus, String numeProdus, String brand, String numeMagazin, double pret,
		String numeClient, int nrFactura, String data, int cantitate, String metodaPlata) {
	super();
	this.id = id;
	this.codProdus = codProdus;
	this.numeProdus = numeProdus;
	this.brand = brand;
	this.numeMagazin = numeMagazin;
	this.pret = pret;
	this.numeClient = numeClient;
	this.nrFactura = nrFactura;
	this.data = data;
	this.cantitate = cantitate;
	this.metodaPlata = metodaPlata;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCodProdus() {
	return codProdus;
}
public void setCodProduse(String codProdus) {
	this.codProdus = codProdus;
}
public String getNumeProdus() {
	return numeProdus;
}
public void setNumeProdus(String numeProdus) {
	this.numeProdus = numeProdus;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getNumeMagazin() {
	return numeMagazin;
}
public void setNumeMagazin(String numeMagazin) {
	this.numeMagazin = numeMagazin;
}
public double getPret() {
	return pret;
}
public void setPret(double pret) {
	this.pret = pret;
}
public String getNumeClient() {
	return numeClient;
}
public void setNumeClient(String numeClient) {
	this.numeClient = numeClient;
}
public int getNrFactura() {
	return nrFactura;
}
public void setNrFactura(int nrFactura) {
	this.nrFactura = nrFactura;
}
public String getData() {
	return data;
}
public void setData(String data) {
	this.data = data;
}
public int getCantitate() {
	return cantitate;
}
public void setCantitate(int cantitate) {
	this.cantitate = cantitate;
}
public String getMetodaPlata() {
	return metodaPlata;
}
public void setMetodaPlata(String metodaPlata) {
	this.metodaPlata = metodaPlata;
}


}
