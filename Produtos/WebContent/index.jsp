<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="br.com.produtos.DAO.ProdutoDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Produtos </title>

<jsp:useBean id="produtoDAO" class="br.com.produtos.DAO.ProdutoDAO" ></jsp:useBean>
</head>

<body>

	
	<ul>
		<li> <a href="index.jsp"> Principal </a> </li>
		<li> <a href="login-loja.jsp"> Lojas </a>
		<li> <a href="login-adm.jsp"> Adm </a>
	</ul>
	
	
	<main>
		
		<c:forEach items="${produtoDAO.lista}" var="pro"> 
			<div>
				<p>
					<h3> ${pro.nome}<br> </h3>
					${pro.preco}<br>
					${pro.loja.nome}<br>
			
					${pro.descricao}<br>
				
					até as : ${pro.duracao}<br>
					
				</p>
			</div>	
			<br>
		</c:forEach>
		
	</main>

</body>
</html>