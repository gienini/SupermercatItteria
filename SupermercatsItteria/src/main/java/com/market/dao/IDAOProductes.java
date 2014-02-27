package com.market.dao;

import java.util.List;

import com.market.VO.Producte;

public interface IDAOProductes {

    /**
     * Modifica els stocks de productes
     * 
     * @param p
     *            el producte de la taula a modificar
     * @param n
     *            el valor en que haura de cambiar
     */
    public void setStock(Producte p, int n);

    /**
     * Recupera una llista amb tots els productes de la BBDD
     * 
     * @return una llista de productes
     */
    public List<Producte> getAll();

    /**
     * Recupera una llista amb tots els productes amb stock de la BBDD
     * 
     * @return una llista de productes amb stock
     */
    public List<Producte> getAllAmbStock();

    // ROADMAP
    // public List getProductePerCategoria(String categoria);

}
