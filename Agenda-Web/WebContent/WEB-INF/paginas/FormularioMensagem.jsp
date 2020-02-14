<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulário de Mensagem</title>
</head>
<body>
	<form method="post" action="/mensagem">
		<label>Digite seu nome:</label><br>
		<input type="text" placeholder="Digite seu nome aqui" name="nomeUsuario">
		<button type="submit">Enviar!</button>
	</form>
</body>
</html>