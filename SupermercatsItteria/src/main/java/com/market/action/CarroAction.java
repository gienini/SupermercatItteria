package com.market.action;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.Producte;
import com.market.VO.Sessio;
import com.market.form.CarroForm;

public class CarroAction extends Action {
    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    private final static String FAIL = "fail";
    public ActionForward execute(ActionMapping mapping,ActionForm form,
            HttpServletRequest request,HttpServletResponse response)
            throws Exception {
    	/**
    	 * Aqui obtenim el producte afegit i la seva quantitat
    	 */
    	CarroForm carro = (CarroForm) form;
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
    		 * El producte ja existeix hem de fer un update
    		 */
    		carret.put(producte,carret.get(producte)+carro.getQuantitat());
    		
    	} else {
    		/**
    		 * El producte no existeix, l'afegim directament 
    		 */
    		carret.put(producte, carro.getQuantitat());
    	}
    	sessio.setCarrito(carret);
    	request.getSession().setAttribute("sessio", sessio);
    	
    	//comporvació del funcionament
    	 Sessio sessioara = (Sessio) request.getSession().getAttribute("sessio");
         for ( Producte key : sessioara.getCarrito().keySet() ) {
             System.out.println("tenim " + sessioara.getCarrito().get(key) + " unitats del producte " + key.getNom() + " a la sessio");
         }
        return mapping.findForward(SUCCESS);
    }
}
