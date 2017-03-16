package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MileStone1_SOP1 {
	private int sopIdNumber = 0042; 
	private String sopName = "NightsWatch"; 
	private String SOPAuthor = "Brothers of the Watch";
	private int authorIDnumber = 2001;
	private int priority = 10;
	
	private boolean IsComplete = true;
	private List<Position> positionsAffected = new ArrayList<Position>(); 
	
	//to generate the unique SOP ID numbers. 
	Random rand;
	
	public MileStone1_SOP1() {
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
	
	 public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
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
	public String getSOPAuthor() {
		return SOPAuthor;
	}
	public void setSOPAuthor(String sOPAuthor) {
		SOPAuthor = sOPAuthor;
	}
	public int getAuthorIDnumber() {
		return authorIDnumber;
	}
	public void setAuthorIDnumber(int authorIDnumber) {
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
}
