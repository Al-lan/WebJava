<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Adicionar Produtos</title>

<jsp:useBean id="loja" class="br.com.produtos.model.Loja" scope="session"></jsp:useBean>

</head>
<body>

	<c:import url="nav.html"></c:import>

	<p>
	Bem vindo loja: <c:out value="${loja.nome}"></c:out>
	</p>
	
	<form action="adicionar" method="POST" >
			
		<fieldset>
			<legend> Adicione um Produto </legend>
		
			<p>
				Nome:<br>
				<input type="text" name="nomeProduto" placeholder="Nome">
			</p>
			
			<p>
				Preço: <br> 
				<input type="number" name="preco" Placeholder="Preço">
			</p>
			
			<p>
				Descrição: <br>
				<textarea rows="3" cols="25" maxlength="140"  name="descricao" placeholder="Descrição"> </textarea>
			</p>
			
			<p>
				Duração em horas: <br>
				<input type="number" name="duracao" >
			</p>
			
		</fieldset>
		
		<br>
		Seu id:
		<input type="number" name="id" placeholder="Id" value="${loja.id}" contenteditable="false"><br>
		
		<input type="submit">
					
	</form>

<c:if test="${empty loja.nome }"> <c:redirect url="404.html"></c:redirect> </c:if>	
	
</body>
</html>