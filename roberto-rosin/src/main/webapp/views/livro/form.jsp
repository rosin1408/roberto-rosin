<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Livro</title>

<link type="text/css" rel="stylesheet" href="/roberto-rosin/static/bootstrap-3.3.4/css/bootstrap.min.css">

</head>
<body>
		<form class="form-horizontal" action="/roberto-rosin/livro/" method="POST">
		<div class="container">
			<fieldset>

				<!-- Form Name -->
				<legend>Livro</legend>
				${mensagem}
				<input type="hidden" name="codigo" id="codigo" value="${livro.codigo}">
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nome">Nome</label>
					<div class="col-md-6">
						<input id="nome" name="nome" type="text"
							class="form-control input-md" required value="${livro.nome}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="escritor">Escritor</label>
					<div class="col-md-6">
						<input id="escritor" name="escritor" type="text"
							class="form-control input-md" required value="${livro.escritor}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="anoEdicao">Ano Edição</label>
					<div class="col-md-2">
						<input id="anoEdicao" name="anoEdicao" type="text"
							class="form-control input-md" required value="${livro.anoEdicao}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="classificacao">Classificação</label>
					<div class="col-md-1">
						<input id="classificacao" name="classificacao" type="text"
							class="form-control input-md" required value="${livro.classificacao}">

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