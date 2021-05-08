package cybersoft.java11.crm.biz;

import java.util.List;

import cybersoft.java11.crm.dao.UserDao;
import cybersoft.java11.crm.model.User;

public class UserBiz {
	private UserDao dao;
	
	public UserBiz() {
		// TODO Auto-generated constructor stub
		dao = new UserDao();
	}
	public List<User> findAll(){
		return dao.findAll();
	}
}
