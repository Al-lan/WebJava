package br.com.produtos.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.produtos.DAO.UserDAO;
import br.com.produtos.model.User;

/**
 * Servlet implementation class Autenticar
 */
@WebServlet("/autenticar-user")
public class AutenticarUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutenticarUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User usuario = new User(request.getParameter("login"), request.getParameter("senha"));
		
		if(UserDAO.AutenticarUser(usuario)){
			
			request.getSession().setAttribute("usuario", usuario );
			response.sendRedirect("home.jsp");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
		}else{
			
			request.setAttribute("erro", "Usuário ou Senha inválidos");
			request.getRequestDispatcher("login-adm.jsp").forward(request, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
