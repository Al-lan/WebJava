<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Home </title>
<jsp:useBean id="usuario" class="br.com.produtos.model.User" scope="session"></jsp:useBean>

</head>


Bem vindo : <c:out value="${usuario.login}"></c:out>

	<ul>
		<li> <a href="index.jsp"> Principal </a> </li>
		<li> <a href="login-loja.jsp"> Lojas </a>
		<li> <a href="login-adm.jsp"> Adm </a>
	</ul>

	<ul>
		<li><a href="cadastrar-loja.jsp"> Cadastro de Lojas </a></li>
	</ul>
	
	<c:if test="${user == null}"> <c:redirect url="404.html"></c:redirect> </c:if>
	

</body>
</html>