package com.market.VO;

import org.apache.struts.validator.ValidatorForm;

public class Usuari extends ValidatorForm {

    private String nick;
    private String nom;

    private String pass;
    private String pass2;
    private int edat;
    private String email;
    private String telefon;
    private String compteb;

    // -------------------------------------------------------
    // Contructor Usuari
    // -------------------------------------------------------
    public Usuari() {
        super();
    }

    public Usuari(String nick, String nom, String pass, String pass2, int edat,
            String email, String telefon, String compteb) {
        super();
        this.nick = nick;
        this.nom = nom;
        this.pass = pass;
        this.pass2 = pass2;
        this.edat = edat;
        this.email = email;
        this.telefon = telefon;
        this.compteb = compteb;
    }

    public Usuari(String nick, String pass) {
        super();
        this.nick = nick;
        this.pass = pass;
    }

    // -------------------------------------------------
    // get i set nick
    // -------------------------------------------------

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    // -------------------------------------------------
    // get i set nom
    // -------------------------------------------------
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // -------------------------------------------------
    // get i set pass
    // -------------------------------------------------
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    // -------------------------------------------------
    // get i set edat
    // -------------------------------------------------
    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    // -------------------------------------------------
    // get i set email
    // -------------------------------------------------
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // -------------------------------------------------
    // get i set telefon
    // -------------------------------------------------
    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public String getCompteb() {
        return compteb;
    }

    public void setCompteb(String compteb) {
        this.compteb = compteb;
    }

}
