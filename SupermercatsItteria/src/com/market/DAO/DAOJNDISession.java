package com.market.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.market.VO.Producte;
import com.market.VO.Sessio;
import com.market.VO.Usuari;

public class DAOJNDISession implements IDAOSessions {

    @Override
    public Sessio getSessio(Usuari u) {

        Connection con = ConnectionStatic.getConnection();
        PreparedStatement ps;
        Sessio rSesio = null;
        try {
            ps = con.prepareStatement("SELECT nomproducte, quantitat, id FROM comandes where idusuari='"
                    + u.getNick() + "' AND pagat=0");
            ResultSet rs = ps.executeQuery();
            rs.next();

            rSesio = new Sessio(u.getNick(), null, rs.getInt(3));
            Map<Producte, Integer> carrito = new HashMap<Producte, Integer>();
            carrito.put(new Producte(rs.getString(1)), rs.getInt(2));
            while (rs.next()) {
                carrito.put(new Producte(rs.getString(1)), rs.getInt(2));
            }
            rSesio.setCarrito(carrito);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rSesio;
    }

    @Override
    public boolean populateDB(Sessio s, String compte_bancari) {
        Connection con = ConnectionStatic.getConnection();
        PreparedStatement ps;
        if (compte_bancari == null) {

            try {
                //borrem els registres de la comanda antiga si existeixen
                ps = con.prepareStatement("DELETE FROM comandes WHERE id="
                        + s.getIdComanda() + " AND idusuari='" + s.getNick()
                        + "';");
                ps.executeQuery();
                //Utilitzem set per iterar sobre un map
                Set<Producte> mySet = s.getCarrito().keySet();
                for (Producte producte : mySet) {
                    ps= con.prep
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
}
