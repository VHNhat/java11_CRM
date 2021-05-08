package cybersoft.java11.crm.biz;

import java.sql.SQLException;

import cybersoft.java11.crm.dao.AuthDao;
import cybersoft.java11.crm.model.User;

public class AuthBiz {
	private AuthDao dao;
	
	public AuthBiz() {
		dao = new AuthDao();
	}
	
	public User login(String email, String password) {
		User user = null;
		
		try {
			user = dao.login(email, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
}
