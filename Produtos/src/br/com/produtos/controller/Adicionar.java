package br.com.produtos.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.produtos.DAO.LojaDAO;
import br.com.produtos.DAO.ProdutoDAO;
import br.com.produtos.model.Loja;
import br.com.produtos.model.Produto;

/**
 * Servlet implementation class Adicionar
 */
@WebServlet("/adicionar")
public class Adicionar extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Adicionar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nomeProduto");

		BigDecimal preco = BigDecimal.valueOf(Double.valueOf(request.getParameter("preco")));

		String descricao = request.getParameter("descricao");
		
		Date duracao = new Date();
		duracao.setHours(duracao.getHours()+Integer.valueOf(request.getParameter("duracao")));
		
		long l = Long.valueOf(request.getParameter("id"));
		System.out.println(l);
		Loja loja = LojaDAO.readLoja(l);
		
		Produto produto = new Produto(nome, descricao, preco, duracao, loja);
		
		ProdutoDAO.create(produto);
		
		request.getRequestDispatcher("adicionar-produto.jsp").forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
