package com.market.dao;

import com.market.VO.Usuari;

public interface IDAOUsuaris {
    
    public void addUsuari(Usuari u);
    public boolean isLogin(Usuari u);
    

}