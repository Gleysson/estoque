package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	private static Connection conn;
	
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tjw?useTimezone=true&serverTimezone=UTC",
					"root",
					""
				);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}

}
