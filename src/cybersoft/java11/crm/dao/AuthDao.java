package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.User;

public class AuthDao {
	public User login(String email, String password) throws SQLException {
		User user = null;
		
		String query = "select id, email, fullname, address, phone, role_id\n" + 
				"from user\n" + 
				"where email = ? and password = ?";
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				user = new User();
				
				user.setId(result.getInt("id"));
				user.setEmail(email);
				user.setFullname(result.getString("fullname"));
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
			}
			
		} catch (SQLException e) {
			// TODO: 
			System.out.println("Error in select query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return user;
	}
}