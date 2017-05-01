package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.SOP;



public class SOPservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("In the revise SOP servlet do get");
		
		//get session information so we can re rout a user or admin back to the login page
		//will help implement a time out in the future 
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("username"));
		if (session.getAttribute("username") == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;
		}
		if(session.getAttribute("type").equals("User")){
			resp.sendRedirect(req.getContextPath() + "/MainPage");

		}
		req.getRequestDispatcher("/_view/Sop.jsp").forward(req, resp);
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			String sopName = null;
			sopName = req.getParameter("sopName");
			Projectcontroller controller = new Projectcontroller();
			controller.pullSOPfromDB(sopName);
		

			if (req.getParameter("index") != null) {
				resp.sendRedirect(req.getContextPath() + "/Index");
			}
		req.getRequestDispatcher("/_view/Sop.jsp").forward(req, resp);

	}


	
}
