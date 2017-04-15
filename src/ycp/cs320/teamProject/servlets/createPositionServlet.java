package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.Position;
import ycp.cs320.teamProject.model.User;


public class createPositionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("CreateAccountServlet: doGet");
		req.getRequestDispatcher("/_view/createPosition.jsp").forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("createPositionServlet: doPost");
		
		//session data 
		User model = new User();
		Position position = new Position();
		String session = getSession(req, "seesionid");
		model.setSessionid(session);
		Projectcontroller controller = new Projectcontroller();
		if (model.getSessionid()== null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}

		
		String name = (String) req.getParameter("positionName");
		String duty = (String) req.getParameter("positionDuty");
		
		controller.addPositionToDatabase(name, duty);
		
		req.setAttribute("sessionid", model);
		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}
		
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);

	}
	private String getSession(HttpServletRequest req, String name) {
		// TODO Auto-generated method stub
		return String.valueOf(req.getParameter(name));
	}



}
