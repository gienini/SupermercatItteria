package com.market.dao;

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

public class JNDIDAOSessions implements IDAOSessions {

    private Map<Producte, Integer> carroR;

    @Override
    public Sessio getSessio(Usuari u) {

        Sessio retorn = new Sessio();

        Connection con = ConnectionStatic.getConnection();

        try {

            // Comprovacio, existeixen comandes guardades per aquest usuari?
            PreparedStatement ps = con
                    .prepareStatement("SELECT idusuari, pagat FROM comandes WHERE idusuari='"
                            + u.getNick() + "' AND pagat=0;");

            ResultSet rs = ps.executeQuery();
            if (rs.absolute(1)) {
                // prenent una comanda que ha estat guardada
                ps = con.prepareStatement("SELECT id, idusuari, nomproducte, quantitat, pagat FROM comandes WHERE idusuari='"
                        + u.getNick() + "' AND pagat=0 ;");

                rs = ps.executeQuery();

                rs.next();

                retorn.setIdComanda(rs.getInt(1));
                retorn.setNick(u.getNick());
                carroR = new HashMap<Producte, Integer>();
                carroR.put(new Producte(rs.getString(3)), rs.getInt(4));
                while (rs.next()) {
                    carroR.put(new Producte(rs.getString(3)), rs.getInt(4));
                }
                retorn.setCarrito(carroR);

            } else {
                ps = con.prepareStatement("SELECT MAX(id), idusuari FROM comandes WHERE idusuari='"
                        + u.getNick() + "' ;");

                rs = ps.executeQuery();
                // Creant una nova comanda
                if (rs.absolute(1)) {
                    retorn = new Sessio(u.getNick(),
                            new HashMap<Producte, Integer>(), rs.getInt(1) + 1);
                } // Creant una nova comanda i una nova relacio de ID
                else {
                    retorn = new Sessio(u.getNick(),
                            new HashMap<Producte, Integer>(), 1);
                }

            }
            con.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }

        return retorn;
    }

    @Override
    public boolean populateDB(Sessio s, String compte_bancari) {

        int pagat = 0;
        if (compte_bancari != null) {
            pagat = 1;
        }
        Sessio retorn = new Sessio();
        ResultSet rs = null;
        Connection con = ConnectionStatic.getConnection();

      
        try {

            // Comprovacio, existeixen comandes guardades per aquest usuari?
            PreparedStatement ps = con
                    .prepareStatement("SELECT idusuari, pagat FROM comandes WHERE idusuari='"
                            + s.getNick() + "' AND pagat=0;");
            rs = ps.executeQuery();
            // Si existeix una comanda guardada la eliminem i en posem una de
            // nova
            if (rs.absolute(1)) {
                ps = con.prepareStatement("DELETE FROM comandes WHERE idusuari='"
                        + s.getNick() + "' AND pagat=0");
                ps.executeUpdate();
            }
            // Buidem la comanda a la BBDD
            Set<Producte> productes = s.getCarrito().keySet();
            int valor = 0;
            for (Producte clave : productes) {
                // Aconseguim el valor per a la clau iterada
                valor = s.getCarrito().get(clave);
                //Comprovem la disponibilitat de stocks

                ps = con.prepareStatement("SELECT stock FROM productes WHERE nom='"+clave+"';");
                rs = ps.executeQuery();
                rs.next();
                if (valor>rs.getInt(1)){
                    //Retornem false quan no hi han prou stocks
                    return false;
                }
                
                ps = con.prepareStatement("INSERT INTO comandes VALUES('"
                        + s.getIdComanda() + "', '" + s.getNick() + "', '"
                        + clave.getNom() + "', " + valor + ", " + pagat + ");");
                ps.executeUpdate();
            }
            
            con.close();rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
