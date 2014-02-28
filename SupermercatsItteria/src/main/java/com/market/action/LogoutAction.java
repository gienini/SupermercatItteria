package com.market.action;

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.GeneratePDF;
import com.market.VO.Sessio;
import com.market.dao.JNDIDAOSessions;
 
public class LogoutAction extends Action {
 
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
    	Sessio data2 =  (Sessio) request.getSession().getAttribute("sessio");
    	//String data = (String) request.getSession().getAttribute("targeta");

    	JNDIDAOSessions sessioDAO = new JNDIDAOSessions();
    	sessioDAO.populateDB(data2, " ");

    	GeneratePDF pdf = new GeneratePDF();
    	if(pdf.getPDF(data2)){}
 
        String target = null;
        target = "success";
        request.getSession().setAttribute("sessio", null);
  
        return mapping.findForward(target);
    }
}
