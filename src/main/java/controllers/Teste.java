package controllers;

import dao.UserDAO;
import beans.User;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user.setName("Eduardo Barros");
		user.setLogin("eduardo@teste.com");
		user.setPassword("123");
		user.setLevel("admin");
		userdao.addUser(user);
		userdao.close();
		
	}

}
