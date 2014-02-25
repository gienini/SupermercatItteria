package com.market.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionStatic {
    
    public static Connection getConnection(){
        Context init;
        DataSource ds;
        Connection con;
        try {
            init = new InitialContext();
            init = (Context) init.lookup("java:comp/env");
            ds = (DataSource) init.lookup("jdbc/b");
            return  ds.getConnection();
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
