package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Role;

public class RoleDao {

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		List<Role> listRole = new LinkedList<Role>();
		
		Connection connection = MySqlConnection.getConnection();
		String query = "select id, name, description from role";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
		
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
		}
		return listRole;
	}
	
	public int insert(Role role) {
		// TODO Auto-generated method stub
		
		Connection connection = MySqlConnection.getConnection();
		String query = "insert into role (id, name, description) values (?, ?, ?)";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, role.getId());
			statement.setString(2, role.getName());
			statement.setString(3, role.getDescription());
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int delete(int id) {
		// TODO Auto-generated method stub
		
		Connection connection = MySqlConnection.getConnection();
		String query = "delete from role where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setInt(1, id);
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(Role role) {
		// TODO Auto-generated method stub
		
		Connection connection = MySqlConnection.getConnection();
		String query = "updaterole name = ?, description =? values where id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			
			statement.setString(1, role.getName());
			statement.setString(2, role.getDescription());
			statement.setInt(3, role.getId());
			return statement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
