package ycp.cs320.teamProject.DBpersist;

import java.util.List;


import ycp.cs320.teamProject.model.*;

public interface IDatabase {
	//*******************
	// User Related methods implemented in Derby Database
	//*******************
	 List<User> getAccountInfo(String name);
	 List<User> matchUsernameWithPassword(String name);	
	 List<User> addUserToDatabase(String name, String pswd, String email, String type, String first, String last);
	 List<User> DeleteUserFromDatabase(String name, String pswd);
	 List<User> changePassword(String name, String pswd, String newPassword);
	 //rework 'delete users from database' to archive 'usersInDatabase'
	
	 
	 
	 //*******************
	 //SOP related methods implemented in derby database
	 //*******************
	 
	 List<SOP> pullSOP(int sopID); 
	 List<SOP> addSOP(final int sopID, final String sopName, final String authorID, final String authorFirstName, final String authorLastName, final String priority, final String revision);
	 List<SOP> changePriority(final int sopID, final String priority, final String newPriority);
	 List<SOP> reviseSOP(final int sopID, final String version, final String newVersion);
	 //archive sop
	
	 //*******************
	 //Position related methods 
	 //*******************
	 
	 //*******************
	 //Training History related methods implemented in derby database
	 //*******************
	 
	 	//going to have a search in this section
	 	//implement sorts
	 
	 //******************
	 //Utility Based methods
	 //******************
	 
	
}
