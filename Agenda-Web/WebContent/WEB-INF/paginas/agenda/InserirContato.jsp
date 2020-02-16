<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir contato</title>
</head>
<body>
	<h2>Inclusão de contato</h2>
	<form method="post" action="${pageContext.request.contextPath}/agenda/incluir">
		<label>Nome do contato</label><br>
		<input type="text" name="nomeContato" placeholder="Digite o nome do contato aqui">
		<label>Idade do contato</label><br>
		<input type="number" name="idadeContato" placeholder="Digite a idade do contato aqui">
		<label>Telefone do contato</label><br>
		<input type="text" name="telefoneContato" placeholder="Digite o telefone do contato aqui">
		<br>
		<button type="submit">Cadastrar!</button>
	</form>
</body>
</html>