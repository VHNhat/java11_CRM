package cybersoft.java11.crm.biz;

import java.sql.SQLException;
import java.util.List;

import cybersoft.java11.crm.dao.RoleDao;
import cybersoft.java11.crm.model.Role;

public class RoleBiz {
	private RoleDao dao;
	
	public RoleBiz() {
		// TODO Auto-generated constructor stub
		dao = new RoleDao();
	}
	
	public List<Role> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public boolean addRole(int id, String name, String description) throws SQLException {
		return dao.addRole(id, name, description);
	}
	
	public boolean removeRole(int id) throws SQLException {
		return dao.removeRole(id);
	}
	
	public boolean update(int id, int newId, String newName, String newDescription) throws SQLException {
		return dao.update(id, newId, newName, newDescription);
	}
}
