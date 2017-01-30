package model;

//import java.util.ArrayList;
import java.util.Queue;


public class PriorityQueue {
	 private Queue<SOP> priorityQueue; 
	 private int queueOwnerID;
	 
	
	 public PriorityQueue() {
		 
	 }
	 
	 /* Commenting this out because it might be added to the controller as a controller method. 
	 public void pushToQueue(SOP sopID) {
		 
	 }*/

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
