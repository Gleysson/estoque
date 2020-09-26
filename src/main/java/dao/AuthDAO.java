package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Cliente;
import beans.User;
import factories.ConnectionFactory;

public class AuthDAO {
	private Connection connection;
	
	public AuthDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	
	public Boolean login(User user) {        
		
    	Boolean auth = false;
    	String sql = "SELECT * FROM users as u WHERE u.login= ? and u.password= ? ";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1,user.getLogin());
            stmt.setString(2,user.getPassword());

            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
            	auth = true;
            }
           
            
        } catch (SQLException e) {
        	System.out.println(e);
            e.printStackTrace();
        }
        
        System.out.println(user.getLogin() +" - "+ user.getPassword());
        System.out.println(auth);
        
		return auth;
        
        
    }
	



}
