package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.ClienteDAO;
import utils.BeanUtilities;


public class  ClienteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ClienteDAO dao;
	private String viewPage;
	private String formPage;
	private String notfoundPage;

	
	public ClienteController() {
		super();
		this.dao = new ClienteDAO();
		this.viewPage = "views/viewCliente.jsp";
		this.formPage = "views/formCliente.jsp";
		this.notfoundPage = "views/notfound.jsp";
	}
	
	private void dispatchToPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher(page);
		view.forward(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String app = request.getParameter("app");

		// P�gina de Cadastro
		if (app.equalsIgnoreCase("cadastro")) {
			dispatchToPage(request, response, formPage);
			return;
		} 
		
		// P�gina de Atualizar
		if (app.equalsIgnoreCase("update")) {
			int id = Integer.parseInt(request.getParameter("clienteId"));
			request.setAttribute("cliente", dao.buscarPorID(id));
			dispatchToPage(request, response, formPage);
			return;
		}

		// Listar Usu�rios
		if (app == null || app.equalsIgnoreCase("listarCliente")) {
			request.setAttribute("clientes", dao.buscarTodos());
			dispatchToPage(request, response, viewPage);
			return;
		}
		
		// A��o de Excluir
		if (app.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("clienteId"));
			dao.remover(id);
			
			request.setAttribute("clientes", dao.buscarTodos());
			dispatchToPage(request, response, viewPage);
			return;
		}
		
		// Caso n�o entre em nenhuma das condi��es
		// significa que n�o reconhecemos essa p�gina ou a��o 
		// logo retornar� uma mensagem de not found
		
		dispatchToPage(request, response, notfoundPage);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cliente cliente = new Cliente();
		BeanUtilities.populateBean(cliente, request);		
		
		if (cliente.getId() == 0) {
			dao.cadastrar(cliente);
		} else {
			dao.atualizar(cliente);
		}
		
		request.setAttribute("clientes", dao.buscarTodos());
		dispatchToPage(request, response, viewPage);
	}

}
