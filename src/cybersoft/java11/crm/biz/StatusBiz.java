package cybersoft.java11.crm.biz;

import java.util.List;

import cybersoft.java11.crm.dao.StatusDao;
import cybersoft.java11.crm.model.Status;

public class StatusBiz {
	private StatusDao dao;
	
	public StatusBiz() {
		// TODO Auto-generated constructor stub
		dao = new StatusDao();
	}
	
	public List<Status> findAll(){
		return dao.findAll();
	}
}
