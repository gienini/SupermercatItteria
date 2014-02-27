package com.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.market.VO.LoginBean;
import com.market.VO.Usuari;

public class JNDIDAOUsuaris implements IDAOUsuaris {

    @Override
    public void addUsuari(Usuari u) {

        Connection con = ConnectionStatic.getConnection();
        try {
            PreparedStatement ps = con
                    .prepareStatement("INSERT INTO usuaris VALUES('"
                            + u.getNick() + "','" + u.getPass() + "', '"
                            + u.getNom() + "', " + u.getEdat() + ", '"
                            + u.getEmail() + "', '" + u.getTelefon()
                            + "', null);");
            ps.executeUpdate();

            con.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean isLogin(LoginBean u) {
        Connection con = ConnectionStatic.getConnection();
        if (u.getUsuari() == null || u.getClau() == null) {
            return false;
        }
        try {
            PreparedStatement ps = con
                    .prepareStatement("SELECT COUNT(*) FROM usuaris WHERE nick='"
                            + u.getUsuari() + "' AND pass='" + u.getClau() + "';");
            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getInt(1)==1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
