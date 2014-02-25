package com.market.Form;

public class sessio {


private String nom;
private float preu;
private int quantitat;


// -------------------------------------------------
//   Retorna el preu per unitat del producte
// -------------------------------------------------
public double getPreu()
{
  return preu;
}

// -------------------------------------------------
//   Retorna el nom del producte
// -------------------------------------------------
public String getNom()
{
  return nom;
}

// -------------------------------------------------
//   Retorna la quantitat del producte
// -------------------------------------------------
public int getQuantitat()
{
  return quantitat;
}


} 