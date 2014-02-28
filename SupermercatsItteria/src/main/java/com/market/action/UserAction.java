/**
 * 
 */

/**
 * @author Alumno18
 *
 */
package com.market.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.market.VO.Usuari;
import com.market.dao.JNDIDAOUsuaris;

public class UserAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        Usuari lf = (Usuari) form; HttpSession sessio= request.getSession();

        JNDIDAOUsuaris DAOUsuaris = new JNDIDAOUsuaris();
        if(!DAOUsuaris.userExists(lf)){
           
            sessio.setAttribute("nick", lf.getNick());
            sessio.setAttribute("nom", lf.getNom());
            sessio.setAttribute("edat", lf.getEdat());
            sessio.setAttribute("email", lf.getEmail());
            sessio.setAttribute("telefon", lf.getTelefon());
            sessio.setAttribute("compteb", lf.getCompteb());

            return mapping.findForward("success");
        }
        else{
            sessio.setAttribute("fail", 1);
            return mapping.findForward("error");
        }
    }

}