package com.market.form;


import org.apache.struts.validator.ValidatorForm;




public class CarroForm extends ValidatorForm {
    
    public int quantitat;
    /**
     * Atributs de producte
     */
    public String nom;
    public float preu;
    public int stock;
    public String url;
    

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
    public int getQuantitat() {
        return quantitat;
    }
    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
    
}
