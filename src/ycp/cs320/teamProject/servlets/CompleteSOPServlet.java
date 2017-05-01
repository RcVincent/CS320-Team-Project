package ycp.cs320.teamProject.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.*;

public class CompleteSOPServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	Projectcontroller c = new Projectcontroller();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//use session info to make sure the user is logged in, and 
		//send them to login if they aren't 
		HttpSession session = req.getSession();
		if (session.getAttribute("username")== null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}
		
		req.getRequestDispatcher("/_view/CompleteSOP.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//set the link to head back to the index page 
		if (req.getParameter("Index") != null) {
			System.out.println("back to index");
			resp.sendRedirect(req.getContextPath() + "/Index");
		} 
		
		
		req.getRequestDispatcher("/_view/CompleteSOP.jsp").forward(req, resp);
	}
}
