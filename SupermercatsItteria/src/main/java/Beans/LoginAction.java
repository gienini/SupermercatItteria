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




public class LoginAction extends Action {

	private static Connection conn;
	private String sql;

 
    
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
    
   
    	LoginForm lf=(LoginForm) form;

    	
    	
    	String clau;
    	ArrayList<String> usuaris=new ArrayList<String>();
    	usuaris=CarregarNomsUsuaris();
    	int ok1=0;
    	int ok2=0;
    	
    	for(int i=0;i<usuaris.size();i++)
    	{

    		if (lf.getUsuari().equals(usuaris.get(i))){
    			
    			ok1=1;
    		}
    	}
    	if(ok1==1)
    	{
    		clau=CarregarPassword(lf.getUsuari());
    		System.out.println("password="+lf.getClau()+" paswordnostre="+clau);
    		if(lf.getClau().equals(clau))
    		{
    			ok2=1;
    		}
    	}
    	if(ok2==1)
    	{
    		HttpSession sessio= request.getSession();
    		sessio.setAttribute("usuari", lf.getUsuari());
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
    
    public String CarregarPassword(String nom)
    {
    	String pass=new String();
    	init();
    	
    	try {
			Statement stmt = conn.createStatement();
			sql = "SELECT pass FROM usuaris WHERE nick='"+nom+"'";
			ResultSet aux = stmt.executeQuery(sql);
			aux.beforeFirst();
			aux.next();
			pass = aux.getString("pass");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return pass;
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
