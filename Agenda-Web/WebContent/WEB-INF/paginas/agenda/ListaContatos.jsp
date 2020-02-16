<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Contatos</title>
</head>
<body>
	<h1>Lista de Contatos</h1>
	<p style="color: red;">${mensagemErro}</p>
	<table style="margin-bottom: 5px;" border="1" cellpadding="5" cellspacing="1">
		<thead>
			<tr>
				<th>Nome</th>
				<th>Idade</th>
				<th>Telefone</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<jstl:forEach items="${contatos}" var="contato">
				<tr>
					<td>${contato.nome}</td>
					<td>${contato.idade}</td>
					<td>${contato.telefone}</td>
					<td><a style="text-decoration: none;" href="${pageContext.request.contextPath}/agenda/editar?id">Editar</a>
						| <a style="text-decoration: none;" href="${pageContext.request.contextPath}/agenda/excluir?id">Excluir</a></td>
				</tr>
			</jstl:forEach>
		</tbody>
	</table>
	<a style="text-decoration: none;" href="${pageContext.request.contextPath}/agenda/incluir">Criar novo
		contato</a>
</body>
</html>