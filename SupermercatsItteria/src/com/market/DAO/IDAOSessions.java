package com.market.DAO;

import java.util.List;

import com.market.VO.Sessio;

public interface IDAOSessions {
    
    public void addComanda(Sessio s);
    public List getAll();

}
