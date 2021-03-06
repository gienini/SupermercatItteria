package com.market.form;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;



public class ContaForm extends ActionForm {

  
private static final long serialVersionUID = 5838376343395991851L;

	private String usertarjeta;
    private String useradreša;
    private String usuari;
    
   public ActionErrors validate(ActionMapping mapping,
           HttpServletRequest request) {
    
       ActionErrors actionErrors = new ActionErrors();
        
       
       if(usertarjeta == null || usertarjeta.trim().equals("")) {
           actionErrors.add("usertarjeta", new ActionMessage("error.usertarjeta"));
       } else if(usertarjeta.length()!=16){
    	   actionErrors.add("usertarjeta", new ActionMessage("error.tamany.tarjeta"));
       }
       try {
       if(useradreša == null || useradreša.trim().equals("")) {
           actionErrors.add("useradreša", new ActionMessage("error.useradreša"));
       }
       }catch(Exception e) {
           e.printStackTrace();
       }
       
       return actionErrors ;
   }

	public String getUsertarjeta() {
		return usertarjeta;
	}
	
	public void setUsertarjeta(String usertarjeta) {
		this.usertarjeta = usertarjeta;
	}
	
	public String getUseradreša() {
		return useradreša;
	}
	
	public void setUseradreša(String useradreša) {
		this.useradreša = useradreša;
	}


}