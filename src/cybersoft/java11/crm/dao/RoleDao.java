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

	/*public List<Role> findAll() throws SQLException {
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
	
	public int addRole(Role role) throws SQLException{
		int result = -1;
		String query = "insert into role(id,name,description)\r\n"
				+ "values (?, ?)";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in insert query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return result; 
	}
	
	public int update(int id, Role role) throws SQLException {
		int result = -1;
		
		String query = "update role\r\n"
				+ "set name = ?, description = ?\r\n"
				+ "where id = ?";
		
		Connection connection = MySqlConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, id);
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error in update query.");
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
		return result;
	}
	*/
	
	public List<Role> findAll(){
		/* return all roles in database */
		List<Role> listRole = new LinkedList<Role>();
		
		Connection connection = MySqlConnection.getConnection();
		try {
			Statement statement = connection.createStatement();
			String query = "select id, name, description from role";
			
			ResultSet results = statement.executeQuery(query);
			
			// iterator
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
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		
		return listRole;
	}
	
	public int addRole(Role role) {
		int result = -1;
		Connection connection = MySqlConnection.getConnection();
		
		try {
			String query = "insert role(`name`, `description`) values(?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
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
	
	public int update(int id, Role role) {
		int result = -1;
		Connection connection = MySqlConnection.getConnection();
		
		try {
			String query = "update role set name=?, description=? where id=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, id);
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		
		return result;
	}
	
	public Role findById(int id) {
		Connection connection = MySqlConnection.getConnection();
		Role result = null;
		
		try {
			String query = "select id, name, description from role where id=?";
			
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Role role = new Role();
				role.setId(resultSet.getInt("id"));
				role.setName(resultSet.getString("name"));
				role.setDescription(resultSet.getString("description"));
				
				result = role;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return result;
	}
}
