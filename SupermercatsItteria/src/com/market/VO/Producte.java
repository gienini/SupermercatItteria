package com.market.VO;

public class Producte {
	
	private String nom;
	private float preu;
	private int stock;
	private String url;

// -------------------------------------------------------
//  Contructor
// -------------------------------------------------------
	
	
public Producte(String nom, float preu, int stock, String url) {
		super();
		this.nom = nom;
		this.preu = preu;
		this.stock = stock;
		this.url = url;
	}


// -------------------------------------------------------
// get i set nom
// -------------------------------------------------------


	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
// -------------------------------------------------------
// get i set preu
// -------------------------------------------------------

	
	public float getPreu() {
		return preu;
	}
	public void setPreu(float preu) {
		this.preu = preu;
	}
	
// -------------------------------------------------------
// get i set stock
// -------------------------------------------------------

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
// -------------------------------------------------------
// get i set url
// -------------------------------------------------------

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}	
	
}
