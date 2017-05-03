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

public class addS2Pservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("addS2P doGet");
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
		req.getRequestDispatcher("/_view/addS2P.jsp").forward(req, resp);
	}	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("addp2u doPost");
		Projectcontroller cont = new Projectcontroller();
		String sop = null;
		String position = null;

		sop = req.getParameter("sop");
		position = req.getParameter("position");

		System.out.println(sop);
		System.out.println(position);
		
		if (sop !=null && position != null) {
			
			// this needs updated cont.addPostionToUser(sop, position);
			cont.addSOPtoPositions(sop, position);
		}
		




		//req.setAttribute("sessionid", model);
		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}

		req.getRequestDispatcher("/_view/addS2P.jsp").forward(req, resp);

	}




}
