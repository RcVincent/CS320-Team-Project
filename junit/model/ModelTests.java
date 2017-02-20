package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import ycp.cs320.teamProject.model.*; 

public class ModelTests {
	 //test users
	 private User user;
	 private User Admin;
	 private boolean isAdmin;
	 //test SOP
	 
	 private SOP sop;
	 
	 //Test positions
	 private Position admin;
	 private Position Manager;
	 private Position regularUser;
	 private ArrayList<Position> positionsAffected;
	 private ArrayList<SOP> sopsAffected; 
	 
	 @Before
	 public void setUp() {
		 user = new User();
		 user.setAccountType(isAdmin = false);
		 
		 user.setUsername("Sir Robin");
		 user.setPassword("bravebravebrave");
		 user.setUserAccountInformation("Eric", "Idle", "junkTrons@junkworld.com");
		 
		 
		 Admin = new User();
		 Admin.setAccountType(isAdmin = true);
		 Admin.setUsername("Bruce");
		 Admin.setPassword("noPuftas");
		 Admin.setUserAccountInformation("Bruce", "Bruce", "australiaWeLoveYouAmen@email.aus");
		 
		 
		 sop= new SOP();
		 sop.setAuthorIDnumber(1002456);
		 sop.setSopName("K.I.S.S");
		 sop.setSopIdNumber(1025649);
		 sop.setPriority(7);
		 positionsAffected = new ArrayList<Position>();
		 
		 
		 positionsAffected.add(Manager);
		 positionsAffected.add(admin);
		 positionsAffected.add(regularUser);
		 
		 admin.setPositionID(1025682);
		 admin.setPositionName("Administrator");
		 
		 regularUser.setPositionID(1102597);
		 regularUser.setPositionName("User");
		 
		 Manager.setPositionID(1200349);
		 Manager.setPositionName("Manager");
		
		 
	 }
	 
	 @Test
	 public void testUsername() {
		 String username = user.getUsername();
		 String username2 = Admin.getUsername();
		 
		 assertEquals("Sir Robin", username);
		 assertEquals("Bruce", username2);
	 }
	 
	 @Test
	 public void testPassword() {
		 String pswd = user.getPassword();
		 String pswd2 = Admin.getPassword();
		 assertEquals("bravebravebrave", pswd);
		 assertEquals("noPuftas", pswd2);
	 }
	 
	 @Test
	 public void testAccountInfo() {
		 String Firstname = user.getFirstName();
		 String firstname = Admin.getFirstName();
		 String Lastname = user.getLastName();
		 String lastname = Admin.getLastName();
		 String Email = user.getEmailAddress();
		 String email = Admin.getEmailAddress();
		 
		 assertEquals("Eric", Firstname);
		 assertEquals("Idle", Lastname);
		 assertEquals("junkTrons@junkworld.com", Email);
		 
		 assertEquals("Bruce", firstname);
		 assertEquals("Bruce", lastname);
		 assertEquals("australiaWeLoveYouAmen@email.aus", email);
	 }
	 
	 @Test
	 public void testAccountType() {
		 boolean use = user.isAccountType();
		 boolean admin = Admin.isAccountType();
		 
		 assertTrue(admin);
		 assertFalse(use);
	 }
	 
	 @Test
	 public void testSOP() {
		 int authorID = sop.getAuthorIDnumber();
		 String sopName = sop.getSopName();
		 int priority = sop.getPriority();
		 int id = sop.getSopIdNumber();
		 
		 assertEquals("K.I.S.S", sopName);
		 assertEquals(7, priority);
		 assertEquals(1002456, authorID);
		 assertEquals(1025649, id);
	 }
	 
	 @Test
	 public void testPositionsAffected() {
		 positionsAffected = new ArrayList<Position>();
		 positionsAffected.add(Manager);
		 positionsAffected.add(admin);
		 positionsAffected.add(regularUser);
		 
		 assertEquals(3, positionsAffected.size());
	 }
	 @Test
	 public void testPosition() {
		 
	 }
}
