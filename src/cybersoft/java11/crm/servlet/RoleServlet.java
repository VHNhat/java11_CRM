package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
//import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.RoleBiz;
import cybersoft.java11.crm.model.Role;
import cybersoft.java11.crm.utils.JspPathConst;
import cybersoft.java11.crm.utils.UrlConstant;

@WebServlet(name = "roleServlet", urlPatterns = {
		UrlConstant.ROLE_DASHBOARD,
		UrlConstant.ROLE_ADD,
		UrlConstant.ROLE_DELETE,
		UrlConstant.ROLE_UPDATE
})
public class RoleServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private RoleBiz biz;
//	private Scanner sc = new Scanner(System.in);
	
	@Override
	public void init() throws ServletException {
		// TODO: init RoleBiz
		super.init();
		biz = new RoleBiz();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String servletPath = req.getServletPath();
		switch(servletPath) {
			case UrlConstant.ROLE_DASHBOARD:
				List<Role> listRole;
				try {
					listRole = biz.findAll();
					req.setAttribute("roles", listRole);
					
					req.getRequestDispatcher(JspPathConst.ROLE_DASHBOARD).forward(req, resp);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case UrlConstant.ROLE_ADD:
				/*System.out.print("Nhap id: ");
				int idAdd = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap name: ");
				String nameAdd = sc.nextLine();
				System.out.print("Nhap description: ");
				String descriptionAdd = sc.nextLine();
				
				try {
					boolean result = biz.addRole(idAdd, nameAdd, descriptionAdd);
					if(result) 
						System.out.println("Add successfully!");
					else
						System.out.println("Add failed!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				break;
			case UrlConstant.ROLE_DELETE:
				/*System.out.print("Nhap id: ");
				int idDelete = Integer.parseInt(sc.nextLine());
				
				try {
					boolean result = biz.removeRole(idDelete);
					if(result) 
						System.out.println("Remove successfully!");
					else
						System.out.println("Remove failed!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				String id = req.getParameter("id");
				try {
					biz.removeRole(Integer.parseInt(id));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resp.sendRedirect(req.getContextPath() + UrlConstant.ROLE_DASHBOARD);
				break;
			case UrlConstant.ROLE_UPDATE:
				/*System.out.print("Nhap id muon update: ");
				int idOld = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap name moi: ");
				String nameUpdate = sc.nextLine();
				System.out.print("Nhap description moi: ");
				String descriptionUpdate = sc.nextLine();
				
				try {
					boolean result = biz.update(idOld, nameUpdate, descriptionUpdate);
					if(result) 
						System.out.println("Update successfully!");
					else
						System.out.println("Update failed!");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				
				req.getRequestDispatcher(JspPathConst.ROLE_UPDATE).forward(req, resp);
				break;
			default:
				break;
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path = req.getServletPath();
		switch(path) {
			case UrlConstant.ROLE_DASHBOARD:
				
				break;
			case UrlConstant.ROLE_ADD:
				String roleName = req.getParameter("role-name");
				String roleDescription = req.getParameter("role-description");
				
				if(roleName == null || roleName.equals("")) {
					req.setAttribute("msg", "Role name can't be emty");
					req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				} else {
					Role newRole = new Role();
					newRole.setName(roleName);
					newRole.setDescription(roleDescription);
					try {
						biz.addRole(newRole);
						resp.sendRedirect(req.getContextPath() + UrlConstant.ROLE_DASHBOARD);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				break;
			case UrlConstant.ROLE_DELETE:
				
				break;
			case UrlConstant.ROLE_UPDATE:
				/*int idUpdate = Integer.parseInt(req.getParameter("id"));
				if(roleName == null || roleName.equals("")) {
					req.setAttribute("msg", "Role name can't be emty");
					req.getRequestDispatcher(JspPathConst.ROLE_ADD).forward(req, resp);
				} else {
					Role newRole = new Role();
					newRole.setName(roleName);
					newRole.setDescription(roleDescription);
					try {
						biz.update(idUpdate, newRole);
						resp.sendRedirect(req.getContextPath() + UrlConstant.ROLE_DASHBOARD);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}*/
				break;
				
			default:
				break;
		
		}
	}
	
	
}
