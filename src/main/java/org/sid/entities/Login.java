package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Login implements Serializable {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLogin;
	private String username;
	private String pwd;
	
	
	public Login() {
	
	}


	public Login(String username, String pwd) {
		super();
		this.username = username;
		this.pwd = pwd;
	}


	public Long getIdLogin() {
		return idLogin;
	}


	public void setIdLogin(Long idLogin) {
		this.idLogin = idLogin;
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

}
