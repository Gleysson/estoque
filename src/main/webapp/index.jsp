<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controle de Estoque</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	
</head>
<body>
	
	<div class="container">.
		<div class="row d-flex justify-content-center align-items-center">
			<div class="card col-md-5">
				<form class="form" action="UserController" name="auth" method="POST">
						
					<br/>
					<h3 class="text-center">Acesse sua Conta</h3>
					<hr/>
				
					<div class="form-group">
						<label>Email</label>
						<input name="login" type="text" class="form-control" required />
					</div>
					
					<div class="form-group">
						<label>Senha</label>
						<input name="password" type="password" class="form-control" required />
					</div>
					
						<%
							String error = (String) request.getAttribute("error");
							if (error != null) {
						%>
							
							<div class="alert alert-danger"> Login ou Senhas Incorretos! </div>
						<% } %>
					
					
					<div class="form-group">
						<button class="btn btn-primary btn-block"> Entrar </button>
					</div>
						
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>