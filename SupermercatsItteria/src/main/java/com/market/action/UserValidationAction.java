/**
 * 
 */

/**
 * @author Alumno18
 *
 */
package com.market.action;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.Usuari;
import com.market.dao.JNDIDAOUsuaris;

public class UserValidationAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Usuari lf = (Usuari) form;

        Usuari nouUsuari = new Usuari(lf.getNick(), lf.getNom(), lf.getPass(),
                null, lf.getEdat(), lf.getEmail(), lf.getTelefon(), null);

        JNDIDAOUsuaris DAOUsuaris = new JNDIDAOUsuaris();
        DAOUsuaris.addUsuari(nouUsuari);

        return mapping.findForward("success");

    }

}