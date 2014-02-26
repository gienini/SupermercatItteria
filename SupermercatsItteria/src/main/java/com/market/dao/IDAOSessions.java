package com.market.dao;

import java.util.List;

import com.market.VO.Sessio;
import com.market.VO.Usuari;

/**
 * 
 * @author Fran Gienini
 * 
 */
public interface IDAOSessions {

    /**
     * Restaura o genera una sessio per a un usuari
     * 
     * @param Usuari
     *            logejat
     * @return la sessio corresponent
     */
    public Sessio getSessio(Usuari u);

    /**
     * Guarda la comanda de la sessio a la BD, si ha estat definit un compte
     * bancari es modifiquen els stocks i es dona la comanda per tancada
     * 
     * @param s
     *            La sessio a guardar
     * @param compte_bancari
     *            introduim null per comandes a mitjes o una String quan la
     *            comanda ha acabat
     * @return
     */
    public boolean populateDB(Sessio s, String compte_bancari);
}
