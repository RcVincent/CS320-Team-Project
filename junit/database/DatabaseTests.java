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
	
	//@Test
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
	
	//@Test
	public void MatchUsernameWithPasswordTest() {
		System.out.println("Testing Matching users with their passwords");
		String userPassword = "password";
		
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
			}
		}
	}
	
	//@Test 
	public void deleteUserFromDatabaseTest(){
		System.out.println("Testing removing users from the database");
		
		String username = "mrSlippyFist";
		String password = "sickBastard";
		String firstname = "Mr.";
		String lastName = "Grazier";
		String email = "IloveTheScouts@scouts.com";
		String type = "user";
		
		userList = db.addUserToDatabase(username, password, email, type, firstname, lastName);
		 
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
}
