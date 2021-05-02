package cybersoft.java11.crm.biz;

import cybersoft.java11.crm.dao.HomeDao;

public class HomeBiz {
	private HomeDao dao;
	
	public HomeBiz() {
		dao = new HomeDao();
	}
	
	public boolean checkHealth() {
		return dao.testConnection();
	}
}
