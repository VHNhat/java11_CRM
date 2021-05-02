package cybersoft.java11.crm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	/* database connection information */
	private static final String url = "jdbc:mysql://localhost:3306/crm";
	private static final String username = "root";
	private static final String password = "1234";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO: 
			e.printStackTrace();
			System.out.println("Driver could not be found.");
		} catch (SQLException e) {
			// TODO:
			e.printStackTrace();
			System.out.println("Can not connect to database.");
		}
		return null;
	}
}
