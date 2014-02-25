package com.market.VO;

public class usuari {
	
	private String nick;
	private String nom;
	private String pass;
	private int edat;
	private String email;
	private int telefon;


// -------------------------------------------------------
//  Contructor Usuari
// -------------------------------------------------------

public Usuari (String UsuariNom, String UsuariPass){
	
	nom = UsuariNom;
	pass = UsuariPass;
	
}

//-------------------------------------------------
//  get i set nom
//-------------------------------------------------
public String getNom()
{
return nom;
}

public void setNom(String nom)
{
	this.nom = nom;
}

//-------------------------------------------------
//get i set pass
//-------------------------------------------------
public String getPass()
{
return pass;
}

public void setPass(String pass)
{
	this.pass = pass;
}

//-------------------------------------------------
//get i set edat
//-------------------------------------------------
public int getEdat()
{
return edat;
}

public void setEdat(int edat)
{
	this.edat = edat;
}

//-------------------------------------------------
//get i set email
//-------------------------------------------------
public String getemail()
{
return email;
}

public void setEmail(String email)
{
	this.email = email;
}

//-------------------------------------------------
//get i set telefon
//-------------------------------------------------
public int getTelefon()
{
return telefon;
}

public void setTelefon(int telefon)
{
	this.telefon = telefon;
}

}
