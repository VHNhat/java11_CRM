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
	
	public int addRole(Role role) throws SQLException {
		return dao.addRole(role);
	}
	
	public boolean removeRole(int id) throws SQLException {
		return dao.removeRole(id);
	}
	
	public int update(int id, Role role) throws SQLException {
		return dao.update(id, role);
	}
}
