package com.market.DAO;

import com.market.VO.Sessio;
import com.market.VO.Usuari;

public class FaceSessioDAO extends JNDIDAOSessions {

    @Override
    public Sessio getSessio(Usuari u) {
        // TODO Auto-generated method stub
        return super.getSessio(u);
    }

    @Override
    public boolean populateDB(Sessio s, String compte_bancari) {
        // TODO Auto-generated method stub
        return super.populateDB(s, compte_bancari);
    }

}
