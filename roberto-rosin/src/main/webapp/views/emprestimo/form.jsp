<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Emprestimo</title>

<link type="text/css" rel="stylesheet"
	href="/roberto-rosin/static/bootstrap-3.3.4/css/bootstrap.min.css">

</head>
<body>
	<form class="form-horizontal" action="/roberto-rosin/emprestimo/"
		method="POST">
		<div class="container">
			<fieldset>

				<!-- Form Name -->
				<legend>Emprestimo</legend>
				${mensagem} <input type="hidden" name="codigo" id="codigo"
					value="${emprestimo.codigo}">

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="pessoa">Pessoa</label>
					<div class="col-md-6">
						<select id="pessoa.codigo" name="pessoa.codigo" class="form-control">
							<c:forEach items="${pessoas}" var="pessoa">
							<option value="${pessoa.codigo}">${pessoa.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="livro">Livro</label>
					<div class="col-md-6">
						<select id="livro.codigo" name="livro.codigo" class="form-control">
							<c:forEach items="${livros}" var="livro">
							<option value="${livro.codigo}">${livro.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-8">
						<button type="submit" class="btn btn-success">Salvar</button>
						<button class="btn btn-default">Voltar</button>
					</div>
				</div>

			</fieldset>
		</div>
	</form>

</body>
</html>