<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Livros</title>
<link type="text/css" rel="stylesheet" href="/roberto-rosin/static/bootstrap-3.3.4/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/roberto-rosin/livro/novo/">Novo</a>
		<table class="table table-striped table-bordered display" id="tabela"
			style="">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Escritor</th>
					<th>Ano Edição</th>
					<th>Classificação</th>
					<th>Opções</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${livros}" var="livro">
					<tr>
						<td>${livro.nome}</td>
						<td>${livro.escritor}</td>
						<td>${livro.anoEdicao}</td>
						<td>${livro.classificacao}</td>
						<td><a href="/roberto-rosin/livro/${livro.codigo}">Alterar </a>
						<a href="/roberto-rosin/livro/${livro.codigo}/excluir">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>
</body>
</html>