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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import javax.servlet.http.HttpSession;

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
		ArrayList<String> usuaris=new ArrayList<String>();
    	usuaris=CarregarNomsUsuaris();
    	int ok1=1;
    	
    	for(int i=0;i<usuaris.size();i++)
    	{

    		if (lf.getUsername().equals(usuaris.get(i))){
    			
    			ok1=0;
    		}
    	}
    	if(ok1==1)
    	{
    	
			HttpSession sessio1= request.getSession();
			sessio1.setAttribute("username", lf.getUsername());
			sessio1.setAttribute("name", lf.getName());
			sessio1.setAttribute("age", lf.getAge());
			sessio1.setAttribute("email", lf.getEmail());
			sessio1.setAttribute("telephone", lf.getTelephone());
			sessio1.setAttribute("compteb", lf.getCompteb());
			return mapping.findForward("success");
    	}else{
    		
    		HttpSession sessioError = request.getSession();
    		sessioError.setAttribute("fail", 1);
    		return mapping.findForward("error");
    	}
		

    }
	
	 public ArrayList<String> CarregarNomsUsuaris(){
	    	
	    	ArrayList<String> llista=new ArrayList<String>();
	    	
	    	init();
	    	
	    	try {
				Statement stmt = conn.createStatement();
				sql = "SELECT nick FROM usuaris";
				ResultSet aux = stmt.executeQuery(sql);
				while(aux.next())
				{
				String ida = aux.getString("nick");
				llista.add(ida);
				}
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return llista;
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