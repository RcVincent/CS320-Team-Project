package ycp.cs320.teamProject.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
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
		//throw new UnsupportedOperationException();//useless exception is useless
		db.changePassword(Username, oldpassword, newpassword);
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

	//find all users in DB
	public List<User>findAllUsers(){
		List<User> userList = db.findAllUsers();

		List<User> Users = new ArrayList<User>();

		for(User user : userList) {
			Users.add(user);
		}

		return Users;

	}
	
	//need a method for pulling an SOP out of the DB based on the SOP number
	public List<SOP> pullSOPfromDB(String sopName) {

		List<SOP> sopList = db.findSOPByName(sopName);

		List<SOP> SOPs = new ArrayList<SOP>();

		for(SOP sop : sopList) {
			SOPs.add(sop);
		}

		return SOPs;
	}


	//pull all sops from BD
	public List<SOP>findAllSOPs(){
		List<SOP> sopList = db.findAllSOPs();

		List<SOP> SOPs = new ArrayList<SOP>();

		for(SOP sop : sopList) {
			SOPs.add(sop);
		}

		return SOPs;

	}

	//get a position by name
	public List<Position>getPositionfromDB(String positionName){
		List<Position> positionList = db.getPositionInfo(positionName);
		List<Position> positions = new ArrayList<Position>();
		for(Position position : positionList){
			positions.add(position);
		}


		return positions;		
	}
	//get all positions
	public List<Position>findAllPositions(){
		List<Position> positionList = db.findAllPositions();
		List<Position> positions = new ArrayList<Position>();
		for(Position position : positionList){
			positions.add(position);
		}


		return positions;		
	}

	//add an SOP to the DB 
	public void addSOPtoDB(String sopName, String sopPurpose, String priority, String revision) {
		db.addSOP(sopName, sopPurpose, priority, revision);
		/* Using this as a bool wasn't working, changed to match addUser which does work.
		 * 
		List<SOP> sopid = db.addSOP(sopName, sopPurpose, priority, revision);

		if(sopid.size() > 0) {
			System.out.println("New SOP (ID: " + sopid + "entered into the database");
			return true;
		}
		else {
			System.out.println("Failed to add the new sop (ID: " + sopid + "to the DB");
			return false;
		}
		 */
	}

	//revise an SOP in the DB
	public void reversionSOP(String name, String version, String newVersion, String purpose) {
		db.reviseSOP(name, version, newVersion, purpose);
	}

	//change an SOP's priority in the DB
	public void changeSOPpriority(String name, String priority, String newPriority){
		db.changePriority(name, priority, newPriority);
	}

	public void addPositionToUser(String user, String position){
		db.addPositionToUser(user, position);

	}

	public void addSOPtoPositions(String sop, String position){
		db.addSOPToPositions(sop, position);
	}

	public static boolean authenticate(User u, String pswd)
	{
		boolean real = false;
		if(u.getPassword().equals(pswd)){

			real = true;
		}

		return real;
	}

	//positions methods
	public void addPositionToDatabase(String name, String duty) {
		db.addPositionToDatabase(name, duty);
	}
	
	//leaving this method here for now, may have to have it put somewhere else 
	public void addToTrainingHistory(SOP sop, User user) {
		TrainingHistory t = new TrainingHistory();
		
		if(t.getUser().getUserID() == user.getUserID() ){
			if(sop.isIsComplete()) {
				t.addToCompleted(sop);
			}
			else {
				t.addToTodoList(sop);
			}
		}
	}
	
	//more  a utility method but will probably be necessary for the servlets 
	public TrainingHistory getHistoryFromUser(User user) {
		TrainingHistory t = user.getTrainingHist();
		
		return t;
	}
	
	//f*ck these next two methods i can't figure out how to sort them for the life of me 
	
	/*
	public void sortHistoryByPriority(Integer priority) {
		TrainingHistory t = new TrainingHistory();
		
		t.getCompletedSOPs().sort(priority);
	}*/
	
	/*
	//sorting the priority queue 
	public void sortHistoryByPriority(int priority) {
		TrainingHistory t = new TrainingHistory();
		PriorityQueue<SOP> p = t.getSopsToComplete();
	
		if(p.comparator().equals(priority)) {
			//sort the priority queue
		}
		
	}*/
//Pull all the sops linked from a users position
	public List<SOP>TrainingHistory(String userName){
		List<SOP> sopList = db.trainingHistory(userName);

		List<SOP> SOPs = new ArrayList<SOP>();

		for(SOP sop : sopList) {
			SOPs.add(sop);
		}

		return SOPs;
	}
}
