package com.market.DAO;

import com.market.VO.Usuari;

/**
 * 
 * @author Fran Gienini
 * 
 */
public interface IDAOUsuaris {

    
     public void addUsuari(Usuari u);
     /**
      * Comprova si la combinacio d'usuari i contrasenya existeixen a la BBDD, existeix un constructor de Usuari especific per aquesta tasca
      * @param Combinacio d'usuari i contrasenya
      * @return confirmacio
      */
     public boolean isLogin(Usuari u);

}
