package com.market.dao;

import java.util.List;

import com.market.VO.Producte;

public interface IDAOProductes {

    public void setStock(Producte p, int n);

    public List getAll();

    public List getAllAmbStock();

    public Producte getProductePerNom(String nom);

//    public List getProductePerCategoria(String categoria);

}
