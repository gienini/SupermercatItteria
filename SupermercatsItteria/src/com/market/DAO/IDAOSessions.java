package com.market.DAO;

import java.util.List;

import com.market.VO.Sessio;
import com.market.VO.Usuari;

/**
 * 
 * @author Fran Gienini
 * 
 */
public interface IDAOSessions {

    public Sessio getSessio(Usuari u);

    public boolean populateDB(Sessio s, String compte_bancari);
}
