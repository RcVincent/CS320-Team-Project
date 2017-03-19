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
	 List<User> changeUsername(final String name, final String newName, final String pswd);
	 //possibly change 'changeUsername' to 'changePassword'
	 //rework 'delete users from database' to archive 'usersInDatabase'
	 
	 
	 //*******************
	 //SOP related methods implemented in derby database
	 //*******************
	 
	 //pull sop based on SOP id number 
	 //archive sop
	 
	 //*******************
	 //Training History related methods implemented in derby database
	 //*******************
	 
	 	//going to have a search in this section
	 	//implement sorts
	 
	 //******************
	 //Utility Based methods
	 //******************
	 
	
}
