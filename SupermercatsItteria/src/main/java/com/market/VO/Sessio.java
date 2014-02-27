package com.market.VO;

import java.util.Map;

public class Sessio {

    private String nick;
    private Map<Producte, Integer> carrito;
    private int idComanda;

    public Sessio() {
        super();
    }

    public Sessio(String nick, Map<Producte, Integer> carrito, int idComanda) {
        super();
        this.nick = nick;
        this.carrito = carrito;
        this.idComanda = idComanda;
    }

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

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    // -------------------------------------------------
    // get i set
    // -------------------------------------------------

}
