package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import cybersoft.java11.crm.config.MySqlConnection;

public class HomeDao {
	
	public boolean testConnection() {
		Connection connection = MySqlConnection.getConnection();
		if(connection == null)
			return false;
		
		return true;
	}
	
	public boolean checkHealth() {
		boolean result = false;
		Connection connection = MySqlConnection.getConnection();
		if(connection == null)
			return result;
		
		String test = "select 1 from dual";
		try {
			Statement statement = connection.createStatement();
			result = statement.execute(test);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
