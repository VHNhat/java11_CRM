package cybersoft.java11.crm.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cybersoft.java11.crm.biz.RoleBiz;
import cybersoft.java11.crm.model.Role;

@WebServlet(name = "roleServlet", urlPatterns = {
		"/roles",
		"/roles/add",
		"/roles/delete",
		"/roles/update"
})
public class RoleServlet extends HttpServlet {


	private static final long serialVersionUID = 1L;

	private RoleBiz biz;
	private Scanner sc = new Scanner(System.in);
	
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
			case "/roles":
				List<Role> listRole;
				try {
					listRole = biz.findAll();
					
					for(Role role : listRole) {
						resp.getWriter().append(role.toString());
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/roles/add":
				System.out.print("Nhap id: ");
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
				}
				break;
			case "/roles/delete":
				System.out.print("Nhap id: ");
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
				}
				break;
			case "/roles/update":
				System.out.print("Nhap id muon update: ");
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
				}
				break;
			default:
				break;
			
		}
		
	}
}
