package com.market.VO;

import org.apache.struts.action.ActionForm;

public class LoginBean extends ActionForm {
    private String usuari;
    private String clau;

    public LoginBean() {
        super();
    }

    public LoginBean(String usuari, String clau) {
        super();
        this.usuari = usuari;
        this.clau = clau;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getClau() {
        return clau;
    }

    public void setClau(String clau) {
        this.clau = clau;
    }
}
