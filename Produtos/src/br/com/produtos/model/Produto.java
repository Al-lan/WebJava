package br.com.produtos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Basic
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private BigDecimal preco;
	
	@Column(name = "duracao")
	@Temporal(TemporalType.TIME)
	private Date duracao;
	
	@ManyToOne
	@JoinColumn(name = "id_loja",  referencedColumnName="id_loja")
	private Loja loja;
	
	public Produto() {
		
	}
	
	public Produto(String nome, String descricao, BigDecimal preco, Date duracao, Loja loja) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.duracao = duracao;
		this.loja = loja;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDuracao() {
		return duracao;
	}

	public void setDuracao(Date duracao) {
		this.duracao = duracao;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

}
