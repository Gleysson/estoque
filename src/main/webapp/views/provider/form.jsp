<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta charset="utf-8" />
<title> 
	${not empty fdfd ? "Atualizando Fornecedor "  : "Cadastrar Fornecedor"}
</title>
<link rel="stylesheet" href="./css/style.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Cadastro Fornecedor</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarText">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="ProviderController?app=listar">Fornecedores</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="ProductController?app=listar">Produtos</a>
      </li>
      
      <li class="nav-item">
        <a class="nav-link" href="#">Estoque</a>
      </li>
    </ul>
    
  </div>
</nav>
	
	<div class="container">.
		<div class="row d-flex ">
			
			<div class="offset-md-2 col-md-8 mt-4">
				<form class="form row" action="ProviderController" method="POST">
					<input type="hidden" name="id" value="${fornecedor.id}"><br>
					
					<div class="form-group col-md-6">
							<label>Nome</label>
							<input name="name" type="text" class="form-control"  value="${fornecedor.name}" />
					</div>
					
					<div class="form-group col-md-6">
							<label>Ramo de Atividade</label>
							<input name="activity" type="text" class="form-control"  value="${fornecedor.activity}" />
					</div>
					
					<div class="form-group col-md-12">
							<label>CNPJ</label>
							<input name="cnpj" type="text" class="form-control"  value="${fornecedor.cnpj}" />
					</div>
					
					<div class="form-group col-md-3">
							<label>UF</label>
							<input name="uf" type="text" max-lenght="2" class="form-control"  value="${fornecedor.uf}" />
					</div>
					
					
					<div class="form-group col-md-4">
							<label>Cidade</label> 
							<input name="city" type="text" class="form-control"  value="${fornecedor.city}" />
					</div>
					
					<div class="form-group col-md-5">
							<label>Endereço</label>
							<input name="address" type="text" class="form-control"  value="${fornecedor.address}" />
					</div>
					
					<div class="form-group col-md-6">
							<label>CEP</label>
							<input name="zipcode" type="text" class="form-control"  value="${fornecedor.zipcode}" />
					</div>
					
					<div class="form-group col-md-6">
							<label>Contato</label>
							<input name="contact" type="text" class="form-control"  value="${fornecedor.contact}" />
					</div>
					
					<div class="form-group col-md-12">
							<label>Telefone</label>
							<input name="phone" type="text" class="form-control"  value="${fornecedor.phone}" />
					</div>
					
						
					<div class="form-group col-md-12">
						<button class="btn btn-primary"> ${not empty fornecedor ? "Atualizar Fornecedor "  : "Cadastrar Fornecedor"} </button>
					</div>
					
					
				
				</form>
			</div>
		</div>
	</div>	
       
    
    
	
</body>
</html>