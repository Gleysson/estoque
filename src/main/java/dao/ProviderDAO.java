package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Provider;
import beans.Cliente;

import factories.ConnectionFactory;

public class ProviderDAO {
	private Connection connection;
	
	public ProviderDAO() {
		connection = ConnectionFactory.getConnection();
	}
	
	public void cadastrar (Provider provider) {
		
		try {
			PreparedStatement st = connection.prepareStatement("INSERT INTO providers (activity,address,city, cnpj, contact, name, phone, uf, zipcode) VALUES (?,?,?,?,?,?,?,?,?)");
			st.setString(1, provider.getActivity());
			st.setString(2, provider.getAddress());
			st.setString(3, provider.getCity());
			st.setString(4, provider.getCnpj());
			st.setString(5, provider.getContact());
			st.setString(6, provider.getName());
			st.setString(7, provider.getPhone());
			st.setString(8, provider.getUf());
			st.setString(9, provider.getZipcode());

			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Provider provider) {
		String sql = "update providers set  activity=?,address=?,city=?, cnpj=?, contact=?, name=?, phone=?, uf=?, zipcode=? where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, provider.getActivity());
			st.setString(2, provider.getAddress());
			st.setString(3, provider.getCity());
			st.setString(4, provider.getCnpj());
			st.setString(5, provider.getContact());
			st.setString(6, provider.getName());
			st.setString(7, provider.getPhone());
			st.setString(8, provider.getUf());
			st.setString(9, provider.getZipcode());
			st.setLong(10, provider.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public List<Provider> buscarTodos () {
		List<Provider> list = new ArrayList<Provider>();
		
		String sql = "SELECT * FROM providers";
			
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while (rs.next()) {
	             Provider provider = new Provider();
	             provider.setActivity(rs.getString("activity"));
	             provider.setAddress(rs.getString("address"));
	             provider.setCity(rs.getString("city"));
	             provider.setCnpj(rs.getString("cnpj"));
	             provider.setContact(rs.getString("contact"));
	             provider.setName(rs.getString("name"));
	             provider.setPhone(rs.getString("phone"));
	             provider.setUf(rs.getString("uf"));
	             provider.setZipcode(rs.getString("zipcode"));
	             provider.setId(rs.getLong("id"));
	             list.add(provider);
	        }
			
			
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public Provider buscarPorID(int id) {
        Provider provider = new Provider();
        
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM providers WHERE id=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
 	             provider.setActivity(rs.getString("activity"));
 	             provider.setAddress(rs.getString("address"));
 	             provider.setCity(rs.getString("city"));
 	             provider.setCnpj(rs.getString("cnpj"));
 	             provider.setContact(rs.getString("contact"));
 	             provider.setName(rs.getString("name"));
 	             provider.setPhone(rs.getString("phone"));
 	             provider.setUf(rs.getString("uf"));
 	             provider.setZipcode(rs.getString("zipcode"));
 	             provider.setId(rs.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return provider;
    }
	
	public void remover(int id) {

		try {
        
            PreparedStatement st = connection.prepareStatement("DELETE FROM providers WHERE id=?");
            st.setInt(1, id);
            st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
