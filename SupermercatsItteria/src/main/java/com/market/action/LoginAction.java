package com.market.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.LoginBean;
import com.market.VO.Producte;
import com.market.VO.Sessio;
import com.market.VO.Usuari;
import com.market.dao.JNDIDAOSessions;
import com.market.dao.JNDIDAOUsuaris;

public class LoginAction extends Action {

    private static Connection conn;
    private String sql;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        LoginBean lf = (LoginBean) form;

        JNDIDAOUsuaris DAOUsuaris = new JNDIDAOUsuaris();
        JNDIDAOSessions DAOSessions = new JNDIDAOSessions();

        if (DAOUsuaris.isLogin(new LoginBean(lf.getUsuari(), lf.getClau()))) {

            Sessio sessioBean = DAOSessions.getSessio(new Usuari(
                    lf.getUsuari(), lf.getClau()));
            HttpSession sessio = request.getSession();
            sessio.setAttribute("sessio", sessioBean);
            return mapping.findForward("success");
        }
        HttpSession sessioError = request.getSession();
        sessioError.setAttribute("fail", 1);
        return mapping.findForward("error");
    }

}
