package com.market.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
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
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        if (getQuantitat() <= 0 ) {
            //TODO el missatge no es mostra
            errors
            .add("producte", new ActionMessage(
                    "err.producte.positive"));
        }   
        return errors;
    }

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
