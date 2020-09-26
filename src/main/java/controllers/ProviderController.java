package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import beans.Provider;
import dao.ClienteDAO;
import dao.ProviderDAO;
import utils.BeanUtilities;


public class  ProviderController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProviderDAO dao;
	private String viewPage;
	private String formPage;
	private String notfoundPage;

	
	public ProviderController() {
		super();
		this.dao = new ProviderDAO();
		this.viewPage = "views/provider/view.jsp";
		this.formPage = "views/provider/form.jsp";
		this.notfoundPage = "views/notfound.jsp";
	}
	
	private void dispatchToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");

		// Página de Cadastro
		if (app.equalsIgnoreCase("cadastro")) {
			dispatchToPage(request, response, formPage);
			return;
		} 
		
		// Página de Atualizar
		if (app.equalsIgnoreCase("atualizar")) {
			int id = Integer.parseInt(request.getParameter("fornecedorId"));
			request.setAttribute("fornecedor", dao.buscarPorID(id));
			dispatchToPage(request, response, formPage);
			return;
		}

		// Listar Usuários
		if (app == null || app.equalsIgnoreCase("listar")) {
			request.setAttribute("clientes", dao.buscarTodos());
			dispatchToPage(request, response, viewPage);
			return;
		}
		
		// Ação de Excluir
		if (app.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("fornecedorId"));
			dao.remover(id);
			
			request.setAttribute("fornecedores", dao.buscarTodos());
			dispatchToPage(request, response, viewPage);
			return;
		}
		
		// Caso não entre em nenhuma das condições
		// significa que não reconhecemos essa página ou ação 
		// logo retornará uma mensagem de not found
		
		dispatchToPage(request, response, notfoundPage);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Provider fornecedor = new Provider();
		BeanUtilities.populateBean(fornecedor, request);		
		
		if (fornecedor.getId() == 0) {
			dao.cadastrar(fornecedor);
		} else {
			dao.atualizar(fornecedor);
		}
		
		request.setAttribute("fornecedores", dao.buscarTodos());
		dispatchToPage(request, response, viewPage);
	}

}
