package ycp.cs320.teamProject.controllers;

import java.util.ArrayList;
import java.util.List;

import ycp.cs320.teamProject.DBpersist.*;
import ycp.cs320.teamProject.model.*;


public class Projectcontroller {
	private IDatabase db;
	
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
	
	public ArrayList<User> getAccountInformation(String username){
		List<User> userList = db.getAccountInfo(username);
		
		ArrayList<User> users = new ArrayList<User>();
		
		for(User user : userList) {
			users.add(user);
		}
		
		return users;
	}
	
	
	public void changeUserName(String Username, String newUsername, String password) {
		
	}
	
	public void addUserToDatabase(String userName, String passWord, String email, String type, String firstName, String lastname) {
		db.addUserToDatabase(userName, passWord, email, type, firstName, lastname);
	}
	
	public void DeleteUserFromDatabase(String Username, String password){
		db.DeleteUserFromDatabase(Username, password);
	}
	
	
	//utility methods 
	public void pushToPriorityQueue(){
		
	}
}
