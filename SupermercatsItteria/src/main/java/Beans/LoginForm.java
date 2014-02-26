package Beans;
import org.apache.struts.action.*;

public class LoginForm extends ActionForm{


	private String usuari;
	private String clau;


	public LoginForm() {
		super();
	}
	private static final long serialVersionUID = 104092268304152302L;


	public String getUsuari() {
		return usuari;
	}
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	public String getClau() {
		return clau;
	}
	public void setClau(String clau) {
		this.clau = clau;
	}

}