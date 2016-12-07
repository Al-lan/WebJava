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

	<c:import url="nav.html"></c:import>
	
	<div>
		
		<c:forEach items="${produtoDAO.lista}" var="pro"> 
			<div>
				<p>
					<h3> ${pro.nome}<br> </h3>
					${pro.preco}<br>
					${pro.loja.nome}<br>
			
					${pro.descricao}<br>
				
					Até as : ${pro.duracao}<br>
					
				</p>
			</div>	
			<br>
		</c:forEach>
		
	</div>

</body>
</html>