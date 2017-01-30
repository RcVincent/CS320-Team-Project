package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ycp.cs320.teamProject.model.*; 

public class ModelTests {
	 private User user;
	 private User Admin;
	
	 private SOP sop;
	 
	 @Before
	 public void setUp() {
		 user = new User();
		 user.setAccountType("user");
		 user.setUsername("Sir Robin");
		 user.setPassword("bravebravebrave");
		 user.setUserAccountInformation("Eric", "Idle", "junkTrons@junkworld.com");
		 
		 Admin = new User();
		 Admin.setAccountType("Administrator");
		 Admin.setUsername("Bruce");
		 Admin.setPassword("noPuftas");
		 Admin.setUserAccountInformation("Bruce", "Bruce", "australiaWeLoveYouAmen@email.aus");
		 
		 sop= new SOP();
		 
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
	 
	 
	 public void testAccountType() {
		 
	 }
}
