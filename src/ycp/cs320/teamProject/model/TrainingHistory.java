package ycp.cs320.teamProject.model;

import java.util.ArrayList;

public class TrainingHistory {
	
	private int UserID;
	
	ArrayList<SOP> completedSOPs = new ArrayList<SOP>(); 
	//BinaryHeap<SOP> sopsToComplete = new BinaryHeap<SOP>();
	ArrayList<SOP> sopsToComplete = new ArrayList<SOP>();
	
	public TrainingHistory() {
		
	}
	
	public void addToCompleted(SOP sop) {
		completedSOPs.add(sop);
	}
	
	public void addToTodoList(SOP sop) {
		sopsToComplete.add(sop);
	}
	
	public void pushFromTodoToCompleted(SOP sop){
		for(int i = 0; i < sopsToComplete.size(); i++) {
			if(sopsToComplete.get(i).getSopIdNumber() == sop.getSopIdNumber()) {
				completedSOPs.add(sop);
				sopsToComplete.remove(sop);
			}
		}
	}
	
	public void pushFromCompletedToTodo(SOP sop){
		for(int i = 0; i < completedSOPs.size(); i++) {
			if(completedSOPs.get(i).getSopIdNumber() == sop.getSopIdNumber());
		}
	}
	
	public int TrainingHistorySize() {
		return sopsToComplete.size() + completedSOPs.size();
	}

	
	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}
	
}
