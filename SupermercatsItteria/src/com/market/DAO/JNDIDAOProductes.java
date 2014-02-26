package com.market.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.market.VO.Producte;
import com.market.VO.Sessio;

public class JNDIDAOProductes implements IDAOProductes {

    @Override
    public void setStock(Producte p, int n) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<Producte> getAll() {
        List<Producte> retorn = new ;
        ResultSet rs = null;
        Connection con = ConnectionStatic.getConnection();
        
        try {
            PreparedStatement ps= con.prepareStatement("SELECT url, nom, preu, stock FROM productes");
            rs= ps.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List getAllAmbStock() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Producte getProductePerNom(String nom) {
        // TODO Auto-generated method stub
        return null;
    }

}
