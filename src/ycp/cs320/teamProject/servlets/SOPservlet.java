package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

		System.out.println("In the SOP servlet do get");
		
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
		SOP sop = null;
		String errorMessage   = null;
		List<SOP> sops = null;
		System.out.println("In the SOP servlet do post");
		String sopName = null;
		sopName = req.getParameter("sopName");



		if (sopName == null || sopName.equals("")) {
			errorMessage = "Please specify the SOP's name";
		} else {
			Projectcontroller controller = new Projectcontroller();

			// get sops from DB
			sops = controller.pullSOPfromDB(sopName);

			// any sops found?
			if (sops == null) {
				errorMessage = "No SOP's found with name: " + sopName;
			}
			else {
				sop = sops.get(0);

			}
		}


		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}

		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("sop",   sop);
		req.setAttribute("sops",  sops);
		req.getRequestDispatcher("/_view/Sop.jsp").forward(req, resp);

	}



}
