package com.market.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
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
                // Construim una llista de noms de productes
                String whereIn = "'" + rs.getString(3) + "', ";
                String nom = "";
                carroR = new HashMap<Producte, Integer>();
                carroR.put(new Producte(rs.getString(3)), rs.getInt(4));
//Omplim el carro amb productes i quantitats
                while (rs.next()) {
                    nom = rs.getString(3);
                    whereIn = whereIn + nom + "', '";
                    carroR.put(new Producte(rs.getString(3)), rs.getInt(4));
                }
                whereIn = whereIn.substring(0, whereIn.length() - 2);
                System.out.println("TENIM EL IN: " + whereIn);

                // Consulta de preus de productes
                ps = con.prepareStatement("SELECT url, nom, preu, stock FROM productes WHERE nom IN ("
                        + whereIn + ");");

                rs = ps.executeQuery();
                
                Map<Producte, Integer> mapa2 = carroR;
                Integer valor=0;
                String clau="";
                //Substituim el hasmap per tenir els detalls del producte
                while (rs.next()) {
                    valor= carroR.get(new Producte(rs.getString(2)));
                    carroR.remove(new Producte(rs.getString(2)));
                    carroR.put(new Producte(rs.getString(2),rs.getFloat(3),rs.getInt(4),rs.getString(1)),valor);
                    System.out.println("HE ENTRAT I LA CUANTITAT ES: "+valor);
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
        }
        return retorn;
    }

    @Override
    public boolean populateDB(Sessio s, String compte_bancari) {

        int pagat = 0;
        if (compte_bancari != null) {
            pagat = 1;
        }
        ResultSet rs = null;
        Connection con = ConnectionStatic.getConnection();
        Set<Producte> setProductes = null;
        int valor = 0;
        // Comprovacio, existeix una comanda en aquesta sessio?
        if (s.getCarrito().entrySet().isEmpty()) {
            return false;

        }
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
            // COMENÇAMENT comprovacions de stocks
            if (compte_bancari != null) {

                // Buidem la comanda a la BBDD
                Iterator<Producte> productes = s.getCarrito().keySet()
                        .iterator();
                valor = 0;

                // Construim una llista de noms de productes
                String whereIn = "'";
                String nom = "";

                while (productes.hasNext()) {
                    nom = productes.next().getNom();
                    whereIn = whereIn + nom + "', '";
                }
                whereIn = whereIn.substring(0, whereIn.length() - 3);
                // Consultem a la BD els stocks disponibles

                ps = con.prepareStatement("SELECT stock, nom FROM productes WHERE nom IN ("
                        + whereIn + ");");
                rs = ps.executeQuery();
                // Els comparem amb la comanda que volem entrar
                while (rs.next()) {

                    if (rs.getInt(1) < s.getCarrito().get(
                            new Producte(rs.getString(2)))) {
                        // Si no hi ha prou stock retornem false
                        return false;
                    }
                }
                setProductes = s.getCarrito().keySet();
                // Actualitzem els stocks
                for (Producte clave : setProductes) {
                    valor = s.getCarrito().get(clave);
                    JNDIDAOProductes DAOProductes = new JNDIDAOProductes();
                    DAOProductes.setStock(clave, valor);

                }
            }// FI actualitzacio stocks

            // Actualitzem la taula de comandes
            setProductes = s.getCarrito().keySet();
            for (Producte clave : setProductes) {
                // Aconseguim el valor per a la clau iterada
                valor = s.getCarrito().get(clave);

                ps = con.prepareStatement("INSERT INTO comandes VALUES('"
                        + s.getIdComanda() + "', '" + s.getNick() + "', '"
                        + clave.getNom() + "', " + valor + ", " + pagat + ");");
                ps.executeUpdate();
            }

            con.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
