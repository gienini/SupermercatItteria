package com.market.DAO;

import com.market.VO.Usuari;

/**
 * 
 * @author Fran Gienini
 * 
 */
public interface IDAOUsuaris {
    /**
     * Funcio per donar d'alta usuaris a la seccio de registre
     * 
     * @param u
     *            l'usuari a donar d'alta
     */

    public void addUsuari(Usuari u);

    /**
     * Comproba si la combinacio d'usuari i contrasenya existeixen a la BBDD,
     * existeix un constructor de Usuari especific per aquesta tasca
     * 
     * @param u
     *            Combinacio d'usuari i contrasenya
     * @return l'usuari logejat
     */
    public Usuari isLogin(Usuari u);

}
