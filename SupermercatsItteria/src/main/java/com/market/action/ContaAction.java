package com.market.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.form.ContaForm;
 
public class ContaAction extends Action {
 
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     ContaForm data= (ContaForm)form;
     String usertargeta= data.getUsertarjeta();
     String useradreça= data.getUseradreça();
 
     request.setAttribute("targeta", usertargeta);
     request.setAttribute("adreça", useradreça);
 
        String target = null;
        target = "success";
  
        return mapping.findForward(target);
    }
}