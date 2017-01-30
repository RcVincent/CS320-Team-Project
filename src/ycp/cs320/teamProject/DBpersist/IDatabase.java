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
	 
}
