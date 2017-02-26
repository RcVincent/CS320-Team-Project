package ycp.cs320.teamProject.model;

import java.util.ArrayList;

public class TrainingHistory {
	ArrayList<SOP> completedSOPs = new ArrayList<SOP>(); 
	BinaryHeap<SOP> sopsToComplete = new BinaryHeap<SOP>();
	
}
