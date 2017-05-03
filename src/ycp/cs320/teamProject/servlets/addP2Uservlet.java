package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.User;
/*
 * This is to add positions to users which then can be used to make the training history
 * 
 */

public class addP2Uservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("addP2U doGet");
		
		//get session information so we can re rout a user or admin back to the login page
		//will help implement a time out in the future 
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username") == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		//if you are a user you should not be able to see this page
		//redirect non admins to the main page 
		if(session.getAttribute("type").equals("User")){
			resp.sendRedirect(req.getContextPath() + "/MainPage");

		}
		req.getRequestDispatcher("/_view/addP2U.jsp").forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("addp2u doPost");
		Projectcontroller cont = new Projectcontroller();
		String user = null;
		String position = null;

		user = req.getParameter("user");
		position = req.getParameter("position");

		System.out.println(user);
		System.out.println(position);
		
		if (user !=null && position != null) {
			
			cont.addPositionToUser(user, position);

		}
		




		//req.setAttribute("sessionid", model);
		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}

		req.getRequestDispatcher("/_view/addP2U.jsp").forward(req, resp);

	}




}
