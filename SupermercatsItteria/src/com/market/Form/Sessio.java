package com.market.Form;

public class Sessio {


private String nom;
private float preu;
private int quantitat;

//-------------------------------------------------
// Constructor
//-------------------------------------------------


public Sessio(String nom, float preu, int quantitat) {
	super();
	this.nom = nom;
	this.preu = preu;
	this.quantitat = quantitat;
}

//-------------------------------------------------
// get i set nom
//-------------------------------------------------

public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}

//-------------------------------------------------
// get i set preu
//-------------------------------------------------

public float getPreu() {
	return preu;
}
public void setPreu(float preu) {
	this.preu = preu;
}

//-------------------------------------------------
//get i set quantitat
//-------------------------------------------------

public int getQuantitat() {
	return quantitat;
}
public void setQuantitat(int quantitat) {
	this.quantitat = quantitat;
}

} 