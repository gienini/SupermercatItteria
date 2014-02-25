package com.market.DAO;

import java.util.List;

import com.market.VO.Sessio;

/**
 * 
 * @author Fran Gienini
 * 
 */
public interface IDAOSessions {

    public void addComanda(Sessio s);

    public List getAll();

}
