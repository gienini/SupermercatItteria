package com.market.VO;

import java.util.Map;

public class Sessio {


private String nick;
private int quantitat;
private Map<Producte, Integer> carrito;

//-------------------------------------------------
// Constructor
//-------------------------------------------------

public Sessio(String nick, int quantitat, Map<Producte, Integer> carrito) {
	super();
	this.nick = nick;
	this.quantitat = quantitat;
	this.carrito = carrito;
}

//-------------------------------------------------
// get i set
//-------------------------------------------------

public String getNick() {
	return nick;
}

public void setNick(String nick) {
	this.nick = nick;
}

public int getQuantitat() {
	return quantitat;
}

public void setQuantitat(int quantitat) {
	this.quantitat = quantitat;
}

public Map<Producte, Integer> getCarrito() {
	return carrito;
}

public void setCarrito(Map<Producte, Integer> carrito) {
	this.carrito = carrito;
}


}

