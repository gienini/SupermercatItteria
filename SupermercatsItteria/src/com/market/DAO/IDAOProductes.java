package com.market.DAO;

import java.util.List;

import com.market.VO.Producte;

/**
 * 
 * @author Fran Gienini
 * 
 */

public interface IDAOProductes {

    /**
     * funcio per modificar l'stock dels productes
     * 
     * @param Producte
     *            a modificar
     * @param Valor
     *            que fara variar l'stock
     */
    public void setStock(Producte p, int n);

    public List getAll();

    /**
     * 
     * @return tots els productes amb stock superior a 0
     */
    public List getAllAmbStock();

    public Producte getProductePerNom(String nom);

//    public List getProductePerCategoria(String categoria);

}
