package ycp.cs320.teamProject.DBpersist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ycp.cs320.teamProject.DBpersist.InitialData;
import ycp.cs320.teamProject.model.Position;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;

import ycp.cs320.teamProject.model.Position;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;

public class TestDatabase /*implements IDatabase*/{

	private List<User> userList;
	private List<SOP> sopList;
	private List<Position> positionList;
	
	public TestDatabase() {
		userList = new ArrayList<User>();
		sopList = new ArrayList<SOP>();
		positionList = new ArrayList<Position>();
		
		readInitialData();
		
		
	}
	
	public void readInitialData() {
		try {
			userList.addAll(InitialData.getUsers());
			sopList.addAll(InitialData.getSOPs());
			positionList.addAll(InitialData.getPositions());
		} catch (IOException e) {
			throw new IllegalStateException("Couldn't read initial data", e);
		}
	}

	//@Override
	public List<User> getAccountInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<User> matchUsernameWithPassword(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<User> addUserToDatabase(String name, String pswd, String email, String type, String first,
			String last) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

	//@Override
	public List<User> DeleteUserFromDatabase(String name, String pswd) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<User> changePassword(String name, String pswd, String newPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<SOP> pullSOP(int sopID) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<SOP> addSOP(int sopID, String sopName, String authorID, String priority, String revision) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<SOP> changePriority(int sopID, String priority, String newPriority) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<SOP> reviseSOP(int sopID, String version, String newVersion) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Position> getPositionInfo(String position) {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public List<Position> addPositionToDatabase(String name, String duty) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private User findUserByUserID(int userID) {
		for(User user: userList) {
			if(user.getUserID() == userID) {
				return user;
			}
		}
		return null;
	}
	
}
