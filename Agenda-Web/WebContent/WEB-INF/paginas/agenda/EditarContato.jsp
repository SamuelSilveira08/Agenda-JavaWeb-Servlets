<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar contato</title>
</head>
<body>
	<h2>Edição de contato</h2>
	<form method="post" action="${pageContext.request.contextPath}/agenda/editar">
		<label>Nome do contato</label><br>
		<input type="text" name="nomeContato" size=25 value="${contato.nome}"><br>
		<label>Idade do contato</label><br>
		<input type="number" name="idadeContato" style="width: 203px;" value="${contato.idade}"><br>
		<label>Telefone do contato</label><br>
		<input type="text" name="telefoneContato" size=25 style="margin-bottom: 5px;" value="${contato.telefone}" disabled><br>
		<button type="submit">Cadastrar!</button>
	</form>
</body>
</html>