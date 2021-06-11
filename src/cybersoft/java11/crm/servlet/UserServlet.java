package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cybersoft.java11.crm.biz.UserBiz;
import cybersoft.java11.crm.model.Role;
import cybersoft.java11.crm.model.User;
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConstant;
@WebServlet(name = "userServlet", urlPatterns = {
		UrlConstant.USER_DASHBOARD,
		UrlConstant.USER_ADD,
		UrlConstant.USER_DELETE,
		UrlConstant.USER_UPDATE
})
public class UserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private UserBiz biz;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		biz = new UserBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch(path) {
			case UrlConstant.USER_DASHBOARD:
				List<User> listUser = biz.findAll();
				for(int i = 0;i < listUser.size();i++) {
					System.out.println(listUser.get(i));
				}
				
				req.setAttribute("users", listUser);
				
				
				req.getRequestDispatcher(JspPathConst.USER_DASDBOARD).forward(req, resp);
				break;
			case UrlConstant.USER_ADD:
				
				req.getRequestDispatcher(JspPathConst.USER_ADD).forward(req, resp);
				break;
			case UrlConstant.USER_UPDATE:
				int idUpdate = Integer.parseInt(req.getParameter("id"));
				
				User willBeUpdatedUser = biz.findById(idUpdate);
				
				req.setAttribute("user", willBeUpdatedUser);
				req.getRequestDispatcher(JspPathConst.USER_UPDATE).forward(req, resp);
				break;
			case UrlConstant.USER_DELETE:
				int id = Integer.parseInt(req.getParameter("id"));
				biz.deleteUser(id);
				resp.sendRedirect(req.getContextPath() + UrlConstant.USER_DASHBOARD);
				break;
			case UrlConstant.USER_PROFILE:
				req.getRequestDispatcher(JspPathConst.USER_PROFILE).forward(req, resp);
				break;
			
			default:
				break;
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch(path) {
			case UrlConstant.USER_DASHBOARD:
				
				break;
			case UrlConstant.USER_ADD:
				String userEmail = req.getParameter("user-email");
				String userPassword = req.getParameter("user-password");
				String userFullname = req.getParameter("user-fullname");
				String userAddress = req.getParameter("user-address");
				String userPhone = req.getParameter("user-phone");
				int roleId = Integer.parseInt(req.getParameter("user-roleid"));
				
				if(userEmail == null || userEmail.equals("") || userPassword == null || userPassword.equals("")) {
					req.setAttribute("msg", "Email and Password can not be emty");
					req.getRequestDispatcher(JspPathConst.USER_ADD).forward(req, resp);
				} else {
					User newUser = new User();
					Role newRole = new Role();
					newRole.setId(roleId);
					newUser.setEmail(userEmail);
					newUser.setPassword(userPassword);
					newUser.setFullname(userFullname);
					newUser.setAddress(userAddress);
					newUser.setPhone(userPhone);
					newUser.setRole(newRole);
					
					biz.addUser(newUser);
					
					resp.sendRedirect(req.getContextPath() + UrlConstant.USER_DASHBOARD);
				}
				break;
			case UrlConstant.USER_UPDATE:
				String userEmailUpdate = req.getParameter("user-email");
				String userPasswordUpdate = req.getParameter("user-password");
				String userFullnameUpdate = req.getParameter("user-fullname");
				String userAddressUpdate = req.getParameter("user-address");
				String userPhoneUpdate = req.getParameter("user-phone");
				int roleIdUpdate = Integer.parseInt(req.getParameter("user-roleid"));
				int id = Integer.parseInt(req.getParameter("id"));
				
				if(userEmailUpdate == null || userEmailUpdate.equals("") || userPasswordUpdate == null || userPasswordUpdate.equals("")) {
					req.setAttribute("msg", "Email and Password can not be emty");
					req.getRequestDispatcher(JspPathConst.USER_UPDATE).forward(req, resp);
				} else {
					User newUser = new User();
					Role newRole = new Role();
					newRole.setId(roleIdUpdate);
					newUser.setEmail(userEmailUpdate);
					newUser.setPassword(userPasswordUpdate);
					newUser.setFullname(userFullnameUpdate);
					newUser.setAddress(userAddressUpdate);
					newUser.setPhone(userPhoneUpdate);
					newUser.setRole(newRole);
					
					biz.updateUser(id, newUser);
					resp.sendRedirect(req.getContextPath() + UrlConstant.USER_DASHBOARD);
				}
				break;
			case UrlConstant.USER_DELETE:
				
				break;
			case UrlConstant.USER_PROFILE:
				
				break;
			
			default:
				break;
		}
	}
}
