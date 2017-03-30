package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class TrainingHistory {
	private int UserID;
	
	ArrayList<SOP> completedSOPs = new ArrayList<SOP>(); 
	//BinaryHeap<SOP> sopsToComplete = new BinaryHeap<SOP>();
	PriorityQueue<SOP> sopsToComplete = new PriorityQueue<SOP>();
	
	public TrainingHistory() {
		
	}
	
	public void addToCompleted(SOP sop) {
		completedSOPs.add(sop);
	}
	
	public void addToTodoList(SOP sop) {
		sopsToComplete.add(sop);
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
	
	//possibly adding methods here to add and remove SOPs from their respective lists
}
