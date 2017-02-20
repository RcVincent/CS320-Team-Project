package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.List;

public class Position {
	
	private String PositionName; 
	private int positionID;
	private List<SOP> regulatingSOPs = new ArrayList<SOP>();
	
	//find a key for finding the required level of training
	
	public Position() {
		
	}

	
	public String getPositionName() {
		return PositionName;
	}

	public void setPositionName(String positionName) {
		PositionName = positionName;
	}

	public int getPositionID() {
		return positionID;
	}

	public void setPositionID(int positionID) {
		this.positionID = positionID;
	}

	public List<SOP> getRegulatingSOPs() {
		return regulatingSOPs;
	}

	public void setRegulatingSOPs(List<SOP> regulatingSOPs) {
		this.regulatingSOPs = regulatingSOPs;
	}
	
	public void addRegulatedSOP(SOP sop) {
		regulatingSOPs.add(sop);
	}
	
	public int findRelevantSOP(int sopID) {
		int referenceID = 0; 
		for(int i = 0; i < regulatingSOPs.size(); i++) {
			if(regulatingSOPs.get(i).getSopIdNumber() == sopID) {
				referenceID = regulatingSOPs.get(i).getSopIdNumber();
			}
		}
		
		return referenceID;
	}
	
	public ArrayList<SOP> findRelevantSOPs(Position position) {
		ArrayList<SOP> sops = new ArrayList<SOP>();
		
		for(int i = 0; i < regulatingSOPs.size(); i++) {
			if(position.getPositionID() == regulatingSOPs.get(i).getPositionsAffected().get(i).getPositionID());
		}
		
		return sops;
	}
}
