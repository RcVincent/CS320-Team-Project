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


public class createSOPservlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;
	
	private Projectcontroller controller = null;
	
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
		req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String errorMessage = null;
		String sucessMessage = null;
		
		String sopName = null;
		String sopAuthorId = null;
		String strsopID = null;
		String priority = null;
		String revision = null;
		
		int sopID = 0;
		
		sopName = req.getParameter("sop_name");
		strsopID = req.getParameter("sop_id");
		sopAuthorId = req.getParameter("sop_authorID");
		priority = req.getParameter("sop_priority");
		revision = req.getParameter("sop_revision");
		
		if(sopName == null || sopName.equals("") ||
		   strsopID == null || strsopID.equals("") ||
		   sopAuthorId == null || sopAuthorId.equals("") ||
		   priority == null || priority.equals("") ||
		   revision == null || revision.equals("") ||
		   sopAuthorId == null
				) {
			errorMessage = "Please fill in all the require fields";
		} else {
			controller = new Projectcontroller();
			sopID = Integer.parseInt(strsopID);
			
			if(controller.addSOPtoDB(sopName, sopID, sopAuthorId, priority, revision)) {
				sucessMessage = sopName;
			}
			else {
				errorMessage = "Failed to insert the new SOP: " + sopName;
			}
		}
		
		req.setAttribute("sop_id", sopID);
		req.setAttribute("sop_name", sopName);
		req.setAttribute("sop_authorID", sopAuthorId);
		req.setAttribute("sop_priority", priority);
		req.setAttribute("sop_revision", revision);
		
		
		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("successMessage", sucessMessage);
		
		req.getRequestDispatcher("/_view/createSOP.jsp").forward(req, resp);
	}
}
