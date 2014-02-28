package com.market.dao;

import com.market.VO.LoginBean;
import com.market.VO.Usuari;

public interface IDAOUsuaris {
    /**
     * Guarda un usuari a la BBDD
     * 
     * @param u
     *            l'Usuari a guardar a la BBDD, ha de tenir els atributs
     *            seteados
     */
    public void addUsuari(Usuari u);

    /**
     * Comproba si la combinacio de usuari i contrassenya existeixen a la BBDD
     * 
     * @param u
     *            L'usuari per comprovar, nomes son necessaris els atributs
     *            "nick" i "pass"
     * @return true si la combinacio existeix, false si no
     */
    public boolean isLogin(LoginBean u);

    /**
     * Comprova si existeix aquest usuari a la BD
     * 
     * @param u
     *            l'usuari amb nom per comprovar
     * @return true si existeix i false si no
     */
    public boolean userExists(Usuari u);

}
