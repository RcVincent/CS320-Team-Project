package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.controllers.Projectcontroller;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class reviseSOP extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/CreateAccount.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("reviseSOPservlet: doPost");

		//session data 
		User model = new User();
		String session = getSession(req, "seesionid");
		model.setSessionid(session);
		Projectcontroller controller = new Projectcontroller();
		if (model.getSessionid()== null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}
		SOP sop = new SOP();
		String sopID = req.getParameter("sop_Id");
		sop.setSopIdNumber(Integer.parseInt(sopID));
		String sopVersion = (String) req.getParameter("version");
		String newSOPVersion = (String) req.getParameter("newVersion");
		

		controller.reversionSOP(model.getUserID(), sopVersion, newSOPVersion);
		

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
