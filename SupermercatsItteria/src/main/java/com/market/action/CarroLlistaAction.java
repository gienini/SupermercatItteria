package com.market.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import com.market.form.CarroForm;
import com.market.form.CarroLlistaForm;
import com.market.VO.Sessio;
import com.market.VO.Producte;

public class CarroLlistaAction extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
    	/**
    	 * Aqui obtenim el producte afegit i la seva quantitat
    	 */
    	CarroLlistaForm carro = (CarroLlistaForm) form;
    	/*carro.getProducte();
    	carro.getQuantitat();*/
    	/**
    	 * Modifiquem el HashMap del carret, afegint o updatejant els productes
    	 */
    	Sessio sessio = (Sessio) request.getSession().getAttribute("sessio");
    	HashMap<Producte,Integer> carret = new HashMap<Producte,Integer>();
    	carret = (HashMap<Producte, Integer>) sessio.getCarrito();
    	
    	/**
    	 * Creem el producte amb els paramtres recollits per el formulari
    	 */
    	
    	Producte producte = new Producte(carro.getNom(), carro.getPreu(), 0, carro.getUrl());
    	
    	/**
    	 * Hem de buscar el producte dintre el HashMap
    	 */
    	if(carret.containsKey(producte)){ 
    		/**
    		 * El producte ja existeix hem de fer un delete del Map
    		 */
    		carret.remove(producte);
    		
    	} 
    	sessio.setCarrito(carret);
    	request.getSession().setAttribute("sessio", sessio);
			return mapping.findForward("success");
	}
}

