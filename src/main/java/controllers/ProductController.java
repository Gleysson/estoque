package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import beans.Product;
import beans.Provider;
import dao.ClienteDAO;
import dao.ProductDAO;
import dao.ProviderDAO;
import utils.BeanUtilities;


public class  ProductController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductDAO dao;
	private ProviderDAO daoProvider;

	private String viewPage;
	private String formPage;
	private String notfoundPage;

	
	public ProductController() {
		super();
		this.dao = new ProductDAO();
		this.daoProvider = new ProviderDAO();

		this.viewPage = "views/product/view.jsp";
		this.formPage = "views/product/form.jsp";
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
			request.setAttribute("fornecedores", daoProvider.buscarTodos());
			dispatchToPage(request, response, formPage);
			return;
		} 
		
		// Página de Atualizar
		if (app.equalsIgnoreCase("atualizar")) {
			int id = Integer.parseInt(request.getParameter("produtoId"));
			request.setAttribute("fornecedores", daoProvider.buscarTodos());
			request.setAttribute("produto", dao.buscarPorID(id));
			dispatchToPage(request, response, formPage);
			return;
		}

		// Listar
		if (app == null || app.equalsIgnoreCase("listar")) {
			request.setAttribute("produtos", dao.buscarTodos());
			dispatchToPage(request, response, viewPage);
			return;
		}
		
		// Ação de Excluir
		if (app.equalsIgnoreCase("excluir")) {
			int id = Integer.parseInt(request.getParameter("produtoId"));
			dao.remover(id);
			
			request.setAttribute("produtos", dao.buscarTodos());
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
		
		Product p = new Product();
		BeanUtilities.populateBean(p, request);		
		
		if (p.getId() == 0) {
			dao.cadastrar(p);
		} else {
			dao.atualizar(p);
		}
		
		request.setAttribute("produtos", dao.buscarTodos());
		dispatchToPage(request, response, viewPage);
	}

}
