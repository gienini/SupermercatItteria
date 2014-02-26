package com.market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.Usuari;
import com.market.dao.IDAOUsuaris;
import com.market.dao.JNDIDAOUsuaris;

public class UserAction extends Action{


	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Usuari lf=(Usuari) form;
		IDAOUsuaris u=new JNDIDAOUsuaris();
		u.addUsuari(lf);
		return mapping.findForward("success");

    }
}