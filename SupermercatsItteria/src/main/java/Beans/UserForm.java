/**
 * 
 */
package Beans;


import org.apache.struts.validator.ValidatorForm;

public class UserForm extends ValidatorForm{

	
	private static final long serialVersionUID = 1L;
	String username;
	String name;
	int age;
	String pwd;
	String pwd2;
	String email;
	String telephone;
	String compteb;

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCompteb() {
		return compteb;
	}
	public void setCompteb(String compteb) {
		this.compteb = compteb;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	//getter and setter methods

}