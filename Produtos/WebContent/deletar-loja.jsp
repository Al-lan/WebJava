<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deletar loja</title>

<jsp:useBean id="lojaDAO" class="br.com.produtos.DAO.LojaDAO"></jsp:useBean>

</head>
<body>

	<c:import url="nav.html"></c:import>

	<c:forEach items="${lojaDAO.lista}" var="lo"> 
		
		<form method="post" action="deletar-loja">
		
		${lo.nome} <br>
		${lo.id} <br>
		${lo.cnpj} <br>
		
		<input type="text" value="${lo.id}" name="id" style="display: none;">
		
		<input type="submit" value="Deletar">
		
		</form>		

	</c:forEach>


	<c:if test="${empty usuario.login}">
		<c:redirect url="404.html"></c:redirect>
	</c:if>



</body>
</html>