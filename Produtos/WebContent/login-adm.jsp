<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login User</title>
</head>

<body>

	<ul>
		<li> <a href="index.jsp"> Principal </a> </li>
		<li> <a href="login-loja.jsp"> Lojas </a>
		<li> <a href="login-adm.jsp"> Adm </a>
	</ul>
	
	
	
	<form action="autenticar-user" method="POST">

		<p>
		Login:
			<input type="text" name="login" placeholder="login">
		</p>

		<p>
		Senha:
			<input type="password" name="senha" placeholder="Senha">
		</p>
	
		<input type="submit" value="Entrar">

	</form>
	
	<c:if test="${user != null}"> <c:redirect url="home.jsp"></c:redirect> </c:if>
	
	<p>
		<c:out value="${erro}"> </c:out>
	</p>
	
</body>
</html>