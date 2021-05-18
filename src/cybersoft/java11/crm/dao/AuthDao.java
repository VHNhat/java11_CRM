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
		
		String query = "select id, email, fullname, address, phone, role_id\r\n"
						+ "from user\r\n"
						+ "where email = ? and password = ?";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, email);
			statement.setString(2, password);
			
			ResultSet result = statement.executeQuery();
			
			while(result.next()){
				user = new User();
				user.setId(result.getInt("id"));
				user.setEmail(email);
				user.setFullname(result.getString("fullname"));
				user.setAddress(result.getString("address"));
				user.setPhone(result.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in select query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return user;
	}
	public int register(User user) {
		int result = -1;
		Connection connection = MySqlConnection.getConnection();
		
		try {
			String query = "insert user(`email`, `password`, `fullname`) values (?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user.getEmail());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getFullname());
			
			result = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error in insert query");
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public boolean checkEmailExisted(User user) {
		boolean result = true;
		Connection connection = MySqlConnection.getConnection();
		
		String query = "select * from user where email = ?";
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, user.getEmail());
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				result = false;
				System.out.println("Email has been used!");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
