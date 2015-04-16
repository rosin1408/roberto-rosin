<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Pessoa</title>

<link type="text/css" rel="stylesheet" href="/roberto-rosin/static/bootstrap-3.3.4/css/bootstrap.min.css">

</head>
<body>
		<form class="form-horizontal" action="/roberto-rosin/pessoa/" method="POST">
		<div class="container">
			<fieldset>

				<!-- Form Name -->
				<legend>Pessoa</legend>
				${mensagem}
				<input type="hidden" name="codigo" id="codigo" value="${pessoa.codigo}">
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nome">Nome</label>
					<div class="col-md-6">
						<input id="nome" name="nome" type="text"
							class="form-control input-md" required value="${pessoa.nome}">

					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="cpf">CPF</label>
					<div class="col-md-2">
						<input id="cpf" name="cpf" type="text"
							class="form-control input-md" required value="${pessoa.cpf}">

					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="dataNascimento">Data Nascimento</label>
					<div class="col-md-6">
						<input id="dataNascimento" name="dataNascimento" type="text"
							class="form-control input-md" required value="${pessoa.dataNascimento}">

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