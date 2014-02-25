package com.market.DAO;

import java.util.List;

import com.market.VO.producte;

public interface IDAOProductes {

    public void setStock(producte p, int n);

    public List getAll();

    public List getAllAmbStock();

    public producte getProductePerNom(String nom);

//    public List getProductePerCategoria(String categoria);

}
