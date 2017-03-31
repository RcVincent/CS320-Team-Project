package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SOP {
	private int sopIdNumber; 
	private String sopName; 
	private String sopAuthorFirstname;
	private String sopAuthorLastname;
	private String authorIDnumber;
	private String priority;
	private String revision;
	
	private boolean IsComplete;
	private List<Position> positionsAffected = new ArrayList<Position>(); 
	
	//to generate the unique SOP ID numbers. 
	Random rand;
	
	public SOP() {
		//rand = new Random();
		//setSopIdNumber(rand.nextInt(100000));
	}
	
	public ArrayList<Position> showPositionsAffected(int sopID) {
		ArrayList<Position> positions = new ArrayList<Position>();
		
		for(int i = 0; i < positionsAffected.size(); i++) {
			if(positionsAffected.get(i).getRegulatingSOPs().get(i).getSopIdNumber() == sopID) {
				positions.add(positionsAffected.get(i));
			}
		}
		return positions;
	}

	//Auto generated methods 
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getSopIdNumber() {
		return sopIdNumber;
	}
	public void setSopIdNumber(int sopIdNumber) {
		this.sopIdNumber = sopIdNumber;
	}
	public String getSopName() {
		return sopName;
	}
	public void setSopName(String sopName) {
		this.sopName = sopName;
	}
	public String getAuthorIDnumber() {
		return authorIDnumber;
	}
	public void setAuthorIDnumber(String authorIDnumber) {
		this.authorIDnumber = authorIDnumber;
	}

	public List<Position> getPositionsAffected() {
		return positionsAffected;
	}

	public void setPositionsAffected(List<Position> positionsAffected) {
		this.positionsAffected = positionsAffected;
	}

	public boolean isIsComplete() {
		return IsComplete;
	}

	public void setIsComplete(boolean isComplete) {
		IsComplete = isComplete;
	}

	public String getRevision() {
		return revision;
	}

	public void setRevision(String revision) {
		this.revision = revision;
	}

	public String getSopAuthorFirstname() {
		return sopAuthorFirstname;
	}

	public void setSopAuthorFirstname(String sopAuthorFirstname) {
		this.sopAuthorFirstname = sopAuthorFirstname;
	}

	public String getSopAuthorLastname() {
		return sopAuthorLastname;
	}

	public void setSopAuthorLastname(String sopAuthorLastname) {
		this.sopAuthorLastname = sopAuthorLastname;
	}
}
