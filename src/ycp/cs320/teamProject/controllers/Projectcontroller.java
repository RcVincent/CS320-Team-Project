package ycp.cs320.teamProject.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import ycp.cs320.teamProject.DBpersist.*;
import ycp.cs320.teamProject.model.*;


public class Projectcontroller {
	private IDatabase db;
	private TrainingHistory t; 
	
	public Projectcontroller() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		db = DatabaseProvider.getInstance();
	}
	
	//User Methods and db methods 
	public ArrayList<User> matchUserNameWithPassword(String username) {
		
		List<User> userList = db.matchUsernameWithPassword(username);
		
		ArrayList<User> users = new ArrayList<User>();
		
		for(User user : userList) {
			users.add(user);
		}
		
		return users;
	}
	
	//allow a user, or an admin to access a users account information 
	public ArrayList<User> getAccountInformation(String username){
		List<User> userList = db.getAccountInfo(username);
		
		ArrayList<User> users = new ArrayList<User>();
		
		for(User user : userList) {
			users.add(user);
		}
		
		return users;
	}
	
	
	
	//Changed the arguments to newpassword / oldpassword to signify the changing
	//of password rather than username and added the same you had below with a new name~devin
	
	//Allowing a user to change their password 
	public void changeUserPassword(String Username, String oldpassword, String newpassword)  {
		 throw new UnsupportedOperationException();//useless exception is useless
	}
	//Allowing a user to change their username 
	public void changeUsername(String Username, String newUsername, String password)  {
		 throw new UnsupportedOperationException();//useless exception is useless
	}
	
	//adding a user to the database 
	public void addUserToDatabase(String userName, String passWord, String email, String type, String firstName, String lastname) {
		db.addUserToDatabase(userName, passWord, email, type, firstName, lastname);
	}
	
	//need to work out how to change this to archive user, not delete 
	public void DeleteUserFromDatabase(String userName, String password){
		db.DeleteUserFromDatabase(userName, password);
	}
	
	//need a method for pulling an SOP out of the DB based on the SOP number
	public void pullSOPfromDB(int sopNumber) {
		
	}
	
	public static boolean authenticate(User u, String pswd)
	{
		boolean real = false;
		if(u.getPassword().equals(pswd)){

			real = true;
		}
		
		return real;
	}
	
	//utility methods 
	/*public Queue<SOP> pushToPriorityQueue(SOP sopID){
		Queue<SOP> priorityQueue = null;
		if(sopID.getPriority() >= 7) {
			priorityQueue = p.pushToQueue(sopID);
		}
		return priorityQueue;
	}*/
}
