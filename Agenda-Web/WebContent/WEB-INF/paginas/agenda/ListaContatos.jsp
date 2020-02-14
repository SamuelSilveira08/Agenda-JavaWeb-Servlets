<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Contatos</title>
</head>
<body>
	<h1>Lista de Contatos</h1>
	<p style="color: red;">${mensagemErro}</p>
	<table border="1" cellpadding="5" cellspacing="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Idade</th>
				<th>Telefone</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${contatos}" var="contato">
				<tr>
					<td>${contato.nome}</td>
					<td>${contato.idade}</td>
					<td>${contato.telefone}</td>
					<td><a href="agenda/editar?id">Editar</a> | <a
						href="agenda/excluir?id">Excluir</a></td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<a href="agenda/incluir">Criar novo contato</a>
</body>
</html>