package cybersoft.java11.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import cybersoft.java11.crm.config.MySqlConnection;
import cybersoft.java11.crm.model.Status;

public class StatusDao {
	public List<Status> findAll(){
		List<Status> listStatus = new LinkedList<Status>();
	
		Connection connection = MySqlConnection.getConnection();

		try {
			Statement statement = connection.createStatement();
			String query = "select id, name, description from status";
			
			ResultSet results = statement.executeQuery(query);
			while(results.next()) {
				Status newStatus = new Status();
				newStatus.setId(results.getInt("id"));
				newStatus.setName(results.getString("name"));
				newStatus.setDescription(results.getString("description"));
				listStatus.add(newStatus);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStatus;
	}
}
