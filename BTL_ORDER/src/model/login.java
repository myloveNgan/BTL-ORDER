package model;

import java.util.Objects;

public class login {

	private String nameuser;
    private String pass;
    private String name;
	public login(String nameuser, String pass, String name) {
		this.nameuser = nameuser;
		this.pass = pass;
		this.name = name;
	}
	
	public login(String name) {
		this.name = name;
	}

	public login(String nameuser, String pass) {
		this.nameuser = nameuser;
		this.pass = pass;
	}
	public login() {
		
	}

	public String getNameuser() {
		return nameuser;
	}
	public void setNameuser(String nameuser) {
		this.nameuser = nameuser;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "login [nameuser=" + nameuser + ", pass=" + pass + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, nameuser, pass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		login other = (login) obj;
		return Objects.equals(name, other.name) && Objects.equals(nameuser, other.nameuser)
				&& Objects.equals(pass, other.pass);
	}	
}
