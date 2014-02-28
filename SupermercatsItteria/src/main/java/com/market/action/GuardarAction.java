package com.market.action;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.Sessio;
import com.market.dao.JNDIDAOSessions;
import com.market.form.ContaForm;

public class GuardarAction extends Action {
	
	
	  public ActionForward execute(ActionMapping mapping, ActionForm form,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	     
		  Sessio sessio = (Sessio)request.getSession().getAttribute("sessio");
			JNDIDAOSessions dao = new JNDIDAOSessions();
			dao.populateDB(sessio, null);
			request.getSession().setAttribute("sessio", null);
	 
	        String target = null;
	        target = "success";
	        request.getSession().setAttribute("sessio", null);
	  
	        return mapping.findForward(target);
	    }

}
