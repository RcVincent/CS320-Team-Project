package database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ycp.cs320.teamProject.DBpersist.*;
import ycp.cs320.teamProject.model.*;

public class DatabaseTests {
	private IDatabase db = null;
	
	List<User> userList = null;
	List<User> users = null;
	List<SOP> sops = null;
	List<SOP> sopList = null;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// creating DB instance here
		DatabaseProvider.setInstance(new DerbyDatabase());	
		db = DatabaseProvider.getInstance();

	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void addUserToDatabaseTest() throws Exception {
		
		System.out.println("Testing adding users to the database");
		
		String username = "The Argument Curator";
		String password = "noitIsnt";
		String lastname = "Cleese";
		String firstname = "John"; 
		String email = "sillywalksLLC@silly.com";
		String type = "user";
		
		users = db.addUserToDatabase(username, password, email, type, firstname, lastname);
		
		if(users.size() > 0) {
			
			userList = db.getAccountInfo(username);
			
			if(userList.isEmpty()) {
				System.out.println("No users found for Lastname <"+lastname+">");
				fail("Failed to add new user <"+username+">");
			}
			else {
				System.out.println("New user (Username:"+username+"was sucessfully added tp the users table");
				
				//reset the database after a completed test 
				users = db.DeleteUserFromDatabase(username, password);
			}
		}
	}
	
	@Test
	public void MatchUsernameWithPasswordTest() {
		
		System.out.println("Testing Matching users with their passwords");
		String userName = "CrazedHotelOwner";
		String userPassword = "ManuEl!";
		String lastname = "Fawlty";
		String firstname = "Basil";
		String email = "fawltyTowerz@bedlum.com";
		String type = "Admin";
		
		users = db.addUserToDatabase(userName, userPassword, email, type, firstname, lastname);
		
		userList = db.matchUsernameWithPassword(userPassword);
		
		if(userList.isEmpty()) {
			System.out.println("No users found that have this password");
			fail("No accounts with that password exist");
		}
		else {
			List<User> users = new ArrayList<User>(); 
			for(User u: userList) {
				User userToAdd = u;
				users.add(userToAdd);
				System.out.println(u.getUsername() + ", " +u.getFirstName()+ ", " +u.getLastName());
				
				//remove the user from the db after the test 
				users = db.DeleteUserFromDatabase(userName, userPassword);
			}
		}
	}
	
	@Test 
	public void deleteUserFromDatabaseTest(){
		System.out.println("Testing removing users from the database");
		
		String username = "mrSlippyFist";
		String password = "sickBastard";
		String firstname = "Mr.";
		String lastName = "Grazier";
		String email = "IloveTheScouts@scouts.com";
		String type = "user";
		
		userList = db.addUserToDatabase(username, password, email, type, firstname, lastName);
		
		assertEquals(1, userList.size());
		
		if(userList.size() > 0) {
			List<User> deletedUsers= db.DeleteUserFromDatabase(username, password);
			
			if(deletedUsers.isEmpty()) {
				System.out.println();
				fail();
			}	
		else {
			System.out.println("User" + deletedUsers.get(0).getUsername()+ "removed from the database. Yay.");
		}
			
		}
		
	}
	
	//will wait to develop this test case. 
	public void ChangeUsernameTest() {
		//will work on this when the database is populated, 
	}
	
	@Test
	public void getAccountInfoTest() throws Exception {
		//Add user 1
		String Username1 = "Jsnow";
		String userPassword1 = "Winter1sComing";
		String lastname1 = "Snow";
		String firstname1 = "John";
		String email1 = "KingOfTheNorth@CastleBlack.com";
		String type1 = "Admin";
		
		//Add user 2
		String Username2 = "CrazedHotelOwner";
		String userPassword2 = "ManuEl!";
		String lastname2 = "Fawlty";
		String firstname2 = "Basil";
		String email2 = "fawltyTowerz@bedlum.com";
		String type2 = "Admin";
		
		//add the users to the db
		userList = db.addUserToDatabase(Username1, userPassword1, email1, type1, firstname1, lastname1);
		userList = db.addUserToDatabase(Username2, userPassword2, email2, type2, firstname2, lastname2);
		
		//get account information 
		users = db.getAccountInfo(Username1);
		users = db.getAccountInfo(Username2);
		
		if(userList.isEmpty()) {
			System.out.println("There are no users to retrieve information for");
			fail("Need more users");
		}
		else {
			for (User u: users) {
				System.out.println(u.getUsername() +"," + u.getUserID() +"," + u.getEmailAddress() +"," + u.getFirstName() +"," + u.getLastName());
			}
		}
		
		users = db.DeleteUserFromDatabase(Username1, userPassword1);
		users = db.DeleteUserFromDatabase(Username2, userPassword2);
	}
	
	public void testAddSOP() {
		int sopID = 10;
		String sopName = "Electronic Signature";
		String sopPurpose = "Electronic Signature ";
		String priority = "10";
		String revision = "1";
		
		sopList = db.addSOP(sopName, sopPurpose, priority, revision);
		
		if(sopList.isEmpty()) {
			System.out.println("There are no SOPs in the table");
			fail("Add more SOPs");
		}else {
			for(SOP s: sops) {
				System.out.println(s.getSopIdNumber() + ", " + s.getSopName() + ", " + s.getSopPurpose() + ", " + s.getPriority() + ", " + s.getRevision());
			}
		}
		
		
	}
	
	public void testChanegSOPPriority() {
		int sopID = 10;
		String sopName = "Electronic Signature";
		String authorID = "15";
		String priority = "10";
		String revision = "1";
		
		sopList = db.addSOP(sopName, authorID, priority, revision);
		
		if(sopList.isEmpty()) {
			System.out.println("There are no SOPs in the table");
			fail("Add more SOPs");
		}else {
			String newPriority = "9";
			sopList = db.changePriority(sopID, priority, newPriority);
			
			assertEquals("9", sopList.get(0).getPriority());
		}
		
	}
	
	public void testChangeSOPVersion() {
		
	}
	
	public void  testaddPosition() {
		
	}

}
