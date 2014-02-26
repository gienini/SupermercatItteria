package com.market.VO;

public class Usuari {
	
	private String nick;
	private String nom;
	private String pass;
	private String pass2;
	private int edat;
	private String email;
	private int telefon;


// -------------------------------------------------------
//  Contructor Usuari
// -------------------------------------------------------

	public Usuari(String nick, String pass) {
		super();
		this.nick = nick;
		this.pass = pass;
	}
	

//-------------------------------------------------
//get i set nick
//-------------------------------------------------

public String getNick() {
	return nick;
}

public void setNick(String nick) {
	this.nick = nick;
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
//get i set pass2
//-------------------------------------------------
public String getPass2() {
	return pass2;
}

public void setPass2(String pass2) {
	this.pass2 = pass2;
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
public String getEmail()
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
