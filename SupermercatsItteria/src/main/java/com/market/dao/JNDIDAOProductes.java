package com.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.market.VO.Producte;

public class JNDIDAOProductes implements IDAOProductes {

    @Override
    public void setStock(Producte p, int n) {
        Connection con = ConnectionStatic.getConnection();
        try {
            PreparedStatement ps = con
                    .prepareStatement("UPDATE productes SET stock=stock-"+n+" WHERE nom='"+p.getNom()+"';");
            ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Producte> getAll() {

        List<Producte> retorn = new ArrayList<Producte>();
        ResultSet rs = null;
        Connection con = ConnectionStatic.getConnection();

        try {
            PreparedStatement ps = con
                    .prepareStatement("SELECT url, nom, preu, stock FROM productes;");
            rs = ps.executeQuery();
            Producte p = new Producte(null);
            while (rs.next()) {
                p = new Producte(rs.getString(1), rs.getInt(3), rs.getInt(4),
                        rs.getString(2));
                retorn.add(p);
                rs.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorn;
    }

    @Override
    public List<Producte> getAllAmbStock() {
        List<Producte> retorn = new ArrayList<Producte>();
        ResultSet rs = null;
        Connection con = ConnectionStatic.getConnection();

        try {
            PreparedStatement ps = con
                    .prepareStatement("SELECT url, nom, preu, stock FROM productes WHERE stock>0;");
            rs = ps.executeQuery();
            Producte p = new Producte(null);
            while (rs.next()) {
                p = new Producte(rs.getString(1), rs.getInt(3), rs.getInt(4),
                        rs.getString(2));
                retorn.add(p);
                rs.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorn;
    }

}
