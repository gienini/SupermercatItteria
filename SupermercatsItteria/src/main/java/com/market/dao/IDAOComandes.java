package com.market.dao;

import java.util.List;

import com.market.VO.Sessio;

public interface IDAOComandes {
    
    public void addComanda(Sessio c);
    public List getAll();

}
