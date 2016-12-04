package br.com.produtos.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users_prod")
public class User implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String senha;
	
	
	public User() {	
		
	}

	public User(String login, String senha) {
		super();
		this.login = login;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
