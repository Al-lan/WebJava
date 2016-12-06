<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Cadastrar Loja </title>

<jsp:useBean id="usuario" class="br.com.produtos.model.User" scope="session"></jsp:useBean>

</head>

Adm : <c:out value="${usuario.login}"></c:out>

		<ul>
			<li> <a href="index.jsp"> Principal </a> </li>
			<li> <a href="login-loja.jsp"> Lojas </a>
			<li> <a href="login-adm.jsp"> Adm </a>
		</ul>

	
	<form action="cadastrar-loja" method="POST">
			
			<p>
				 Nome da loja <br>
				<input type="text" name="nomeLoja">
			</p>
			
			<p>
				Cnpj<br>
				<input type="text" name="cnpj" >  
			</p>
			
			<p>
				Senha<br>
				<input type="text" name="senha" >  
			</p>		
			
			<input type="submit" value="Cadastrar">
	
	</form>
	
<c:if test="${user == null}"> <c:redirect url="404.html"></c:redirect> </c:if>

</body>
</html>