package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.AuthDAO;
import dao.UserDAO;
import utils.BeanUtilities;


public class  UserController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AuthDAO authDAO;
	private UserDAO dao;
	private String viewPage;
	private String formPage;
	private String notfoundPage;

	
	public UserController() {
		super();
		this.dao = new UserDAO();
		this.authDAO = new AuthDAO();

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
		dispatchToPage(request, response, notfoundPage);
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		BeanUtilities.populateBean(user, request);		
		
		if(authDAO.login(user)) {
			request.getSession().setAttribute("usuario", 'S');
			dispatchToPage(request, response, "views/dashboard.jsp");

		}else {
			request.setAttribute("error", "Usuário ou Senha Incorretos!");
			dispatchToPage(request, response, "index.jsp");
		}
		
	}

}
