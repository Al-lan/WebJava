<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Login User</title>
</head>

<body>

	<c:import url="nav.html"></c:import>
	
	
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
	
	<c:if test="${not empty usuario.login}"> <c:redirect url="home.jsp"></c:redirect> </c:if>
	
	<p>
		<c:out value="${erro}"> </c:out>
	</p>
	
</body>
</html>