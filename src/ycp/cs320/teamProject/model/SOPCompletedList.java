package ycp.cs320.teamProject.model;

import java.util.ArrayList;
import java.util.Collections; 

public class SOPCompletedList {
	
	private ArrayList<SOP> trainingList = new ArrayList<SOP>();
	//SOP sop;
	
	
	public SOPCompletedList() {
		
	}
	
	public void addToList(SOP sop) {
		trainingList.add(sop);
	}
	
	//this will be a search function, possibly add a search criteria to the model/controller 
	public void find(/* find a search criteria tag for searching through the training list */) {
		
	}
	
	public void escalate() {
		
	}
	
}
