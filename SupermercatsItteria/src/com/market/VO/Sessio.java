package com.market.VO;

import java.util.HashMap;
import java.util.Map;

public class Sessio {


private String nick;
private int quantitat;

//-------------------------------------------------
// Constructor
//-------------------------------------------------

private static Map<Producte,Integer> createMap() {
    Map<Producte,Integer> Carrito = new HashMap<Producte,Integer>();
    return Carrito;
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


}
