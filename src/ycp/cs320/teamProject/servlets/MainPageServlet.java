package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.User;




//Priority  # 2
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/MainPage.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User model = new User();
		Projectcontroller controller = new Projectcontroller();
		String session = getSession(req, "seesionid");
		String userName = req.getParameter("userName");
		model.setSessionid(session);
		model.setUsername(userName);
		if (model.getSessionid()== null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		ArrayList<User> users = controller.getAccountInformation(userName);
		User user = users.get(0);
		
		req.setAttribute("user", user);

		req.getRequestDispatcher("/_view/MainPage.jsp").forward(req, resp);
	
		}
		


	private String getSession(HttpServletRequest req, String name) {
		// TODO Auto-generated method stub
		return String.valueOf(req.getParameter(name));
		}
		
		
	
}
