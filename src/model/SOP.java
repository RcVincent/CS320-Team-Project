package model;

import java.util.Random;

public class SOP {
	private int sopIdNumber; 
	private String sopName; 
	private String SOPAuthor;
	private int authorIDnumber;
	
	//to generate the unique SOP ID numbers. 
	Random rand;
	
	public SOP() {
		rand = new Random();
		setSopIdNumber(rand.nextInt(100000));
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
}
