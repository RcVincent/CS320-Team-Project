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
	 private SOP sop2;
	 private SOP sop3;
	 
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
		 
		 sop2 = new SOP();
		 sop2.setAuthorIDnumber(1002456);
		 sop2.setSopName("Dosument Editing");
		 sop2.setSopIdNumber(1025650);
		 
		 sop3 = new SOP();
		 sop3.setAuthorIDnumber(1002568);
		 sop3.setSopName("Stretching Work");
		 sop3.setSopIdNumber(1025651);
		 
		 
		 positionsAffected.add(Manager);
		 positionsAffected.add(admin);
		 positionsAffected.add(regularUser);
		 
		 
		 admin = new Position();
		 admin.setPositionID(1025682);
		 admin.setPositionName("Administrator");
		 
		 regularUser = new Position();
		 regularUser.setPositionID(1102597);
		 regularUser.setPositionName("User");
		 
		 Manager = new Position();
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
		 
		 //assertEquals(3, sop.showPositionsAffected(1002456));
	 }
	 
	 
	 @Test
	 public void testPositionRegulation() {
		 Manager.addRegulatedSOP(sop);
		 Manager.addRegulatedSOP(sop3);
		 
		 assertEquals(2, Manager.getRegulatingSOPs().size());
		 
		 admin.addRegulatedSOP(sop);
		 admin.addRegulatedSOP(sop2);
		 
		 assertEquals(2, admin.getRegulatingSOPs().size());
		 
		 int testsopID = Manager.findRelevantSOP(sop.getSopIdNumber());
		 assertEquals(testsopID, sop.getSopIdNumber());
		 
		 int testsopID2 = admin.findRelevantSOP(sop2.getSopIdNumber());
		 assertEquals(testsopID2,sop2.getSopIdNumber());
		 
	 }
	 
}
