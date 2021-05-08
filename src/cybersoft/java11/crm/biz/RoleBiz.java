package cybersoft.java11.crm.biz;

import java.util.List;

import cybersoft.java11.crm.dao.RoleDao;
import cybersoft.java11.crm.model.Role;

public class RoleBiz {
	private RoleDao dao;
	
	public RoleBiz() {
		// TODO Auto-generated constructor stub
		dao = new RoleDao();
	}
	
	public List<Role> findAll(){
		return dao.findAll();
	}
	
	public int insert(Role role) {
		return dao.insert(role);
	}
	
	public int delete(int id) {
		return dao.delete(id);
	}
	
	public int update(Role role) {
		return dao.update(role);
	}

}
