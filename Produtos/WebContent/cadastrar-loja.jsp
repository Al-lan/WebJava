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

	<c:import url="nav.html"></c:import>
	
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
	
<c:if test="${empty usuario.login }"> <c:redirect url="404.html"></c:redirect> </c:if>

</body>
</html>