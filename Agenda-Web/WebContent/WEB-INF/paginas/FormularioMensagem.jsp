<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulário de Mensagem</title>
</head>
<body>
	<form method="post" action="/Agenda-Web/mensagem">
		<label>Digite seu nome:</label><br>
		<input type="text" placeholder="Digite seu nome aqui" name="nomeUsuario">
		<button type="submit">Enviar!</button>
	</form>
</body>
</html>