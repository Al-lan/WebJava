package br.com.produtos.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lojas")
public class Loja implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_loja")
	private Long id;
	private String nome;
	private String cnpj;
	private String senha;
	
	
	public Loja(String nome, String cnpj, String senha) {
		super();
		this.nome = nome;
		this.cnpj = cnpj;
		this.senha = senha;
	}
	
	public Loja(String cnpj, String senha) {
		super();
		this.cnpj = cnpj;
		this.senha = senha;
	}
	
	public Loja() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	

}
