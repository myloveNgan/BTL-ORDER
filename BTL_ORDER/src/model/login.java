package model;

import java.util.Objects;

public class login {

	private int id;
	private String nameuser;
	private String pass;
	private String name;

	public login() {
	}

	public login(int id, String nameuser, String pass, String name) {
		this.id = id;
		this.nameuser = nameuser;
		this.pass = pass;
		this.name = name;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
}
