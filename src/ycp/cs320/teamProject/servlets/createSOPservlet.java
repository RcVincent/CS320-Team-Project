package ycp.cs320.teamProject.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class createSOPservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);
		String user = (String) req.getSession().getAttribute("User.username");
		SOP model = new SOP();
		if (user == null) {
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/Login");
			return;

		}


		int sopIdNumber = (int) req.getSession().getAttribute("sopIDNumber");
		model.setSopIdNumber(sopIdNumber);
		String sopName = (String) req.getSession().getAttribute("sopName");
		model.setSopName(sopName);
		String sopAuthor = (String) req.getSession().getAttribute("sopAuthor");
		model.setSOPAuthor(sopAuthor);
		int priority = (int) req.getSession().getAttribute("priority");
		model.setPriority(priority);
		model.setRevision(1);

		req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);

	}


}
