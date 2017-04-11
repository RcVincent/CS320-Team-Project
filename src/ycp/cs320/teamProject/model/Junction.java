package ycp.cs320.teamProject.model;

public class Junction {
	private int userID;
	private int sopID;
	private int positionID;
	
	public Junction() {
		
	}
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getSopID() {
		return sopID;
	}
	public void setSopID(int sopID) {
		this.sopID = sopID;
	}
	public int getPositionID() {
		return positionID;
	}
	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}
}
