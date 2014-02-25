package com.market.VO;

import java.util.Map;

public class Sessio {


private String nick;
private Map<Producte, Integer> carrito;

//-------------------------------------------------
// Constructor
//-------------------------------------------------

public Sessio(String nick, Map<Producte, Integer> carrito) {
	super();
	this.nick = nick;

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

public Map<Producte, Integer> getCarrito() {
	return carrito;
}

public void setCarrito(Map<Producte, Integer> carrito) {
	this.carrito = carrito;
}


}

