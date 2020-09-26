<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Fornecedor</title>
<link rel="stylesheet" href="./css/style.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-primary">
  <a class="navbar-brand" href="#">Controle de Estoque</a>
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
		<div class="row">
			
			<div class="col-md-12">
   			    <a class="btn btn-primary"href="ProviderController?app=cadastro"> Novo Fornecedor </a>
			</div>
		
			
			<div class="col-md-12 mt-4">
				<table class="table table-hover">
			        <thead>
			            <tr>
			                
			                <th>Nome</th>
			                <th>CNPJ</th>
			                <th>UF</th>
   			                <th>Cidade</th>
			                <th>Contato</th>
   			                <th>Atividade</th>
   			                <th>Telefone</th>
			                
			                
			                <th colspan=2>Ações</th>
			            </tr>
			        </thead>
			        <tbody>
		              <c:forEach items="${fornecedores}" var="f">
			                <tr>
			                    <td><c:out value="${f.name}" /></td>
       			                <td><c:out value="${f.cnpj}" /></td>
       			                <td><c:out value="${f.uf}" /></td>
       			                <td><c:out value="${f.city}" /></td>
			                   
    			                <td><c:out value="${f.contact}" /></td>
			                    <td><c:out value="${f.activity}" /></td>
			                    <td><c:out value="${f.phone}" /></td>
			                    <td>
			                    	<a class="btn btn-danger" href="ProviderController?app=excluir&fornecedorId=<c:out value="${f.id}"/>">Excluir</a>
			                    	<a class="btn btn-warning" href="ProviderController?app=atualizar&fornecedorId=<c:out value="${f.id}"/>">Atualizar</a>
		                    	</td>
			                </tr>
		               </c:forEach>
			        </tbody>
			    </table>
			</div>
		</div>
	</div>	
       
    
    
	
</body>
</html>