package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Product;
import factories.ConnectionFactory;

public class ProductDAO {
	private Connection connection;
	
	public ProductDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public void cadastrar (Product p) {
		
		try {
			PreparedStatement st = connection.prepareStatement("INSERT INTO products (provider_id, description,name,sale_price, unit_cost) VALUES (?,?,?,?,?)");
			
			st.setInt(1, p.getProvider_id());
			st.setString(2, p.getDescription());
			st.setString(3, p.getName());
			st.setFloat(4, p.getSale_price());
			st.setFloat(5, p.getUnit_cost());


			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Product p) {
		String sql = "update products set  provider_id=?, description=?,name=?,sale_price=?, unit_cost=?, name=? where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, p.getProvider_id());
			st.setString(2, p.getDescription());
			st.setString(3, p.getName());
			st.setFloat(4, p.getSale_price());
			st.setFloat(5, p.getUnit_cost());
			st.setString(6, p.getName());
			st.setLong(7, p.getId());


			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Product> buscarTodos () {
		List<Product> list = new ArrayList<Product>();
		
		String sql = "SELECT * FROM products";
			
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
	            Product p = new Product();
	            p.setId(rs.getLong("id"));
	            p.setDescription(rs.getString("description"));
	            p.setSale_price(rs.getFloat("sale_price"));
	            p.setUnit_cost(rs.getFloat("unit_cost"));
	            p.setName(rs.getString("name"));

	            list.add(p);
	        }
			
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Product buscarPorID(int id) {
    	Product p = new Product();
        
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM products WHERE id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
	            p.setId(rs.getLong("id"));
	            p.setDescription(rs.getString("description"));
	            p.setSale_price(rs.getFloat("sale_price"));
	            p.setName(rs.getString("name"));
	            p.setUnit_cost(rs.getFloat("unit_cost"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return p;
    }
	
	public void remover(int id) {

		try {
        
            PreparedStatement st = connection.prepareStatement("DELETE FROM products WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
