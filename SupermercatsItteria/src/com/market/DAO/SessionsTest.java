package com.market.DAO;

import com.market.VO.Sessio;
import com.market.VO.Usuari;

public class SessionsTest {

    public static void main(String[] args) {
        JNDIDAOSessions sesio = new JNDIDAOSessions();

        Sessio s = sesio.getSessio(new Usuari("fran", "1234"));

        System.out.println(s.getIdComanda());
    }

}
