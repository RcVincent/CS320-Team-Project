package ycp.cs320.teamProject.model;

//import java.util.ArrayList;
import java.util.Queue;


public class PriorityQueue {
	 private Queue<SOP> priorityQueue; 
	 private int queueOwnerID;
	 
	
	 public PriorityQueue() {
		 
	 }
	 
	// this method may be a part of the controller  
	 public Queue<SOP> pushToQueue(SOP sopID) {
		 if(sopID.getPriority() >= 7) {
			 priorityQueue.add(sopID); 
		 }
		return priorityQueue;
	 }
	 
	 

	public int getQueueOwnerID() {
		return queueOwnerID;
	}

	public void setQueueOwnerID(int queueOwnerID) {
		this.queueOwnerID = queueOwnerID;
	}

	public Queue<SOP> getPriorityQueue() {
		return priorityQueue;
	}

	public void setPriorityQueue(Queue<SOP> priorityQueue) {
		this.priorityQueue = priorityQueue;
	}
	 
}
