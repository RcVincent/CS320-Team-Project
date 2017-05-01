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
import ycp.cs320.teamProject.model.User;


public class reviseSOP extends HttpServlet{
	private static final long serialVersionUID = 1L;
	//private getAccountInfo user = null;

	private Projectcontroller controller = null;

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


		req.getRequestDispatcher("/_view/reviseSOP.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String errorMessage = null;
		String sucessMessage = null;

		String sopName = null;
		String sopPurpose = null;
		String priority = null;
		String version = null;
		String newVersion = null;
		String newPriority = null;

		System.out.println("getting SOP info from webform");
		sopName = req.getParameter("sopName");
		sopPurpose = req.getParameter("sop_purpose");
		priority = req.getParameter("sop_priority");
		newPriority = req.getParameter("sop_newPriority");
		version = req.getParameter("sop_Version");
		newVersion = req.getParameter("sop_newVersion");

		System.out.println(sopName);
		System.out.println(sopPurpose);
		System.out.println(priority);
		System.out.println(newPriority);
		System.out.println(version);
		System.out.println(newVersion);
		/*Trying to get addSOP to work with out the check for fields

		if(sopName == null || sopName.equals("") ||
				sopPurpose == null || sopPurpose.equals("") ||
				priority == null || priority.equals("") ||
				revision == null || revision.equals("") 
				) {
			errorMessage = "Please fill in all the require fields";
		} else {
		 */
		controller = new Projectcontroller();
		//sopID = Integer.parseInt(strsopID);
		controller.reversionSOP(sopName, version, newVersion, sopPurpose);
		controller.changeSOPpriority(sopName, priority, newPriority); 
		//sucessMessage = sopName;

		//else {
		//errorMessage = "Failed to insert the new SOP: " + sopName;
		//}

		//took this old because I don't think its actually doing anything
		//req.setAttribute("sop_id", sopID);
		//req.setAttribute("sop_name", sopName);
		//req.setAttribute("sop_Purpose", sopPurpose);
		//req.setAttribute("sop_priority", priority);
		//req.setAttribute("sop_revision", revision);


		req.setAttribute("errorMessage", errorMessage);
		req.setAttribute("successMessage", sucessMessage);
		//}

		if (req.getParameter("index") != null) {
			resp.sendRedirect(req.getContextPath() + "/Index");
		}
		req.getRequestDispatcher("/_view/reviseSOP.jsp").forward(req, resp);
	}

}
