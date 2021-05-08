package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Role;

public class RoleDao {

	public List<Role> findAll() throws SQLException {
		// TODO Auto-generated method stub
		List<Role> listRole = new LinkedList<Role>();
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			Statement statement = connection.createStatement();
			String query = "select id, name, description from role";
			
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				Role newRole = new Role();
				newRole.setId(results.getInt("id"));
				newRole.setName(results.getString("name"));
				newRole.setDescription(results.getString("description"));
				listRole.add(newRole);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			connection.close();
		}
		return listRole;
	}
	
	public boolean addRole(int id, String name, String description) throws SQLException{
		boolean result = false;
		String query = "insert into role(id,name,description)\r\n"
				+ "values (?, ?, ?)";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			statement.setString(2, name);
			statement.setString(3, description);
			
			statement.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in insert query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return result; 
	}
	
	public boolean removeRole(int id) throws SQLException {
		boolean result = false;
		String query = "delete from role \r\n"
				+ "where id = ?";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			statement.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in delete query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return result;
	}
	
	public boolean update(int id,int newId, String newName, String newDescription) throws SQLException {
		boolean result = false;
		
		String query = "update role\r\n"
				+ "set id = ?, name = ?, description = ?\r\n"
				+ "where id = ?";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, newId);
			statement.setString(2, newName);
			statement.setString(3, newDescription);
			statement.setInt(4, id);
			
			statement.execute();
			result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in update query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return result;
	}
}
