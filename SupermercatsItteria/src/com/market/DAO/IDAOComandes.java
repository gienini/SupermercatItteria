package com.market.DAO;

import java.util.List;

import com.market.VO.Sessio;

public interface IDAOComandes {
    
    public void addComanda(Sessio c);
    public List getAll();

}
