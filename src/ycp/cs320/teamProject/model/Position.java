package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.List;

public class Position {
	
	private String PositionName; 
	private int positionID;
	private List<Integer> regulatingSOPs = new ArrayList<Integer>();
	
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

	public List<Integer> getRegulatingSOPs() {
		return regulatingSOPs;
	}

	public void setRegulatingSOPs(List<Integer> regulatingSOPs) {
		this.regulatingSOPs = regulatingSOPs;
	}
	
	public void addRegulatedSOP(int SOPID) {
		regulatingSOPs.add(SOPID);
	}
	
	public int findRelevantSOP(int SOPID) {
		int referenceID = 0; 
		for(int i = 0; i < regulatingSOPs.size(); i++) {
			if(regulatingSOPs.get(i).equals(SOPID)) {
				referenceID = regulatingSOPs.get(i);
			}
		}
		
		return referenceID;
	}
	
	public void addRegulatorySOP(SOP sopToAdd) {
		regulatingSOPs.add(sopToAdd.getSopIdNumber());
	}
	
	
	
}
