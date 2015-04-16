<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pessoas</title>
<link type="text/css" rel="stylesheet" href="/roberto-rosin/static/bootstrap-3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/roberto-rosin/pessoa/novo/">Novo</a>
		<table class="table table-striped table-bordered display" id="tabela"
			style="">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Data Nascimento</th>
					<th>CPF</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pessoas}" var="pessoa">
					<tr>
						<td>${pessoa.nome}</td>
						<td>${pessoa.dataNascimento}</td>
						<td>${pessoa.cpf}</td>
						<td><a href="/roberto-rosin/pessoa/${pessoa.codigo}">Alterar </a>
						<a href="/roberto-rosin/pessoa/${pessoa.codigo}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>