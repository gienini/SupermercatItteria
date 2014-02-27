package com.market.VO;

public class Producte {

    private String nom;
    private float preu;
    private int stock;
    private String url;

    // -------------------------------------------------------
    // Contructor
    // -------------------------------------------------------

    public Producte(String nom) {
        super();
        this.nom = nom;
    }

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

    @Override
    public int hashCode() {
        return nom.length();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Producte)) {
            return false;
        }
        Producte p2 = (Producte) obj;

        return p2.nom.equals(this.nom);
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
