package com.fasttrackit.pojo;

public class Clienti {
private int id;
private String nume;
private String adresa;
private String oras;
private int codPostal;
private String email;
private String telefon;

public Clienti(int id, String nume, String adresa, String oras, int codPostal, String email, String telefon) {
	this.id=id;
	this.nume=nume;
	this.adresa=adresa;
	this.oras=oras;
	this.codPostal=codPostal;
	this.email=email;
	this.telefon=telefon;
}
public Clienti() {
	
}

public void setId(int id) {
	this.id=id;
}

public int getId() {
	return id;
}

public void setNume(String nume) {
	this.nume=nume;
}

public String getNume() {
	return nume;
}

public void setAdresa(String adresa) {
	this.adresa=adresa;
}

public String getAdresa() {
	return adresa;
}
public void setOras(String oras) {
	this.oras=oras;
}

public String getOras() {
	return oras;
}

public void setCodPostal(int codPostal) {
	this.codPostal=codPostal;
}

public int getCodPostal() {
	return codPostal;
}

public void setEmail(String email) {
	this.email=email;
}

public String getEmail() {
	return email;
}

public void setTelefon(String telefon) {
	this.telefon=telefon;
}
public String getTelefon() {
	return telefon;
}
}
