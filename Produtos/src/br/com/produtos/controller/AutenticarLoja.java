package br.com.produtos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.produtos.DAO.LojaDAO;
import br.com.produtos.model.Loja;

/**
 * Servlet implementation class AutentticarLoja
 */
@WebServlet("/autenticar-loja")
public class AutenticarLoja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarLoja() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Loja loja = new Loja(request.getParameter("cnpj"),request.getParameter("senha"));
		
		if(LojaDAO.autenticarLoja(loja)){
			
			request.getSession().setAttribute("loja", loja );
			response.sendRedirect("adicionar-produto.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		}else{
			
			request.setAttribute("erro", "Usuário ou Senha inválidos");
			request.getRequestDispatcher("login-loja.jsp").forward(request, response);
			
		}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
