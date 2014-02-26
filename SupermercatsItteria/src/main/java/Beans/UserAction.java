/**
 * 
 */

/**
 * @author Alumno18
 *
 */
package Beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class UserAction extends Action{

	private static Connection conn;
	private String sql;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		UserForm lf=(UserForm) form;
		
		init();
		
		try {
			Statement stmt = conn.createStatement();
			sql = "INSERT INTO usuaris SET nick='" + lf.getUsername()
					+ "',edat='" + lf.getAge() + "',email='"
					+ lf.getEmail() + "',telefon='"
					+ lf.getTelephone() + "',pass='"+lf.getPwd()+"',nom='"+lf.getName()+"',compteb='"+lf.getCompteb()+"';";
			stmt.executeUpdate(sql);
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mapping.findForward("error");
		}
		return mapping.findForward("success");
    }
	

	public void init() {

		conn=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String servidor="jdbc:mysql://localhost/botiga";
			String usuarioDB="root";
			String passwordDB="";
			conn=DriverManager.getConnection(servidor,usuarioDB,passwordDB);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn=null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			conn=null;
		}catch (Exception e){
			
			e.printStackTrace();
			conn=null;
		}
	}
	
}