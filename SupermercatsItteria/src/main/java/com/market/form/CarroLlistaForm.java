package com.market.form;

import org.apache.struts.validator.ValidatorForm;

public class CarroLlistaForm extends ValidatorForm{
	 private String nom;
	 private float preu;
	 private int stock;
	 private String url;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public float getPreu() {
		return preu;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
