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
	
	//user lists
	List<User> userList = null;
	
	
	//sop Lists
	List<SOP> sopList = null;
	
	//position list
	List<Position> positionList = null;
	
	//junction table lists 
	List<PositionSOP> sopPositionList = null;
	List<UserPosition> userPositionList = null;
	
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
	
	//test if users are being added properly to the database
	@Test
	public void addUserToDatabaseTest() throws Exception {
		
		System.out.println("Testing adding users to the database");
		
		String username = "The Argument Curator";
		String password = "noitIsnt";
		String lastname = "Cleese";
		String firstname = "John"; 
		String email = "sillywalksLLC@silly.com";
		String type = "user";
		
		List<User >users = db.addUserToDatabase(username, password, email, type, firstname, lastname);
		
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
	
	//match a username with their password: for use in authentication when logging in 
	@Test
	public void MatchUsernameWithPasswordTest() {
		
		System.out.println("Testing Matching users with their passwords");
		String userName = "CrazedHotelOwner";
		String userPassword = "ManuEl!";
		String lastname = "Fawlty";
		String firstname = "Basil";
		String email = "fawltyTowerz@bedlum.com";
		String type = "Admin";
		
		List<User> users = db.addUserToDatabase(userName, userPassword, email, type, firstname, lastname);
		
		userList = db.matchUsernameWithPassword(userPassword);
		
		if(userList.isEmpty()) {
			System.out.println("No users found that have this password");
			fail("No accounts with that password exist");
		}
		else {
			List<User> usersToAdd = new ArrayList<User>(); 
			for(User u: userList) {
				User userToAdd = u;
				usersToAdd.add(userToAdd);
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
	
	//testing we get the full list of a users account information 
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
		
		List<User> users = new ArrayList<User>();
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
	
	public void changePasswordTest() {
		
	}
	
	//testing adding an SOP to the DB properly 
	@Test
	public void testAddSOP() {
		
		String sopName = "Electronic Signature";
		String sopPurpose = "Electronic Signature ";
		String priority = "10";
		String revision = "1";
		
		sopList = db.addSOP(sopName, sopPurpose, priority, revision);
		
		if(sopList.isEmpty()) {
			System.out.println("There are no SOPs in the table");
			fail("Add more SOPs");
		}else {
			for(SOP s: sopList) {
				System.out.println(s.getSopIdNumber() + ", " + s.getSopName() + ", " + s.getSopPurpose() + ", " + s.getPriority() + ", " + s.getRevision());
			}
		}
		
		
	}
	
	//testing changing an SOPs priority 
	@Test
	public void testChanegSOPPriority() {
		String sopName = "Electronic Signature";
		String sopPurpose = "Know the impact of your signature";
		String priority = "10";
		String revision = "1";
		
		sopList = db.addSOP( sopName, sopPurpose, priority, revision);
		
		if(sopList.isEmpty()) {
			System.out.println("There are no SOPs in the table");
			fail("Add more SOPs");
			
		}else {
			String newPriority = "9";
			List<SOP> sops = new ArrayList<SOP>();
			sops = db.changePriority(sopName, priority, newPriority);
			
			assertEquals("9", sops.get(0).getPriority());
			
			
		}
		
	}
	
	//testing changing an SOPs version
	@Test
	public void testChangeSOPVersion() {
		
		
		String sopName = "Electronic Signature 2";
		String sopPurpose = "Know the impact of your signature, new and better";
		String priority = "10";
		String version = "1";
		
		sopList = db.addSOP(sopName, sopPurpose, priority, version);
		
		if(sopList.isEmpty()) {
			System.out.println("There are no SOPs in the table");
			fail("Add more SOPs");
			//add a remove method for the SOPs
		}
		else {
			String newVersion = "2";
			List<SOP> sops = new ArrayList<SOP>();
			sops = db.reviseSOP(sopName, version, newVersion, sopPurpose);
			
			assertEquals("2", sops.get(0).getRevision());
			//add a remove method for the SOPs
		}
	}
	
	//testing adding a position to the db properly 
	@Test
	public void  testaddPosition() {
		
		String positionName = "Dr Henry Killinger";
		String positionDuty = "Lead investor";
		
		positionList = db.addPositionToDatabase(positionName, positionDuty);
		
		if(positionList.isEmpty()) {
			System.out.println("Your positions are too scarce: no one will find me in here ");
			fail("Add more positions you silly billy");
		}
		else {
			for(Position p: positionList) {
				System.out.println(p.getPositionIdS() + "," + p.getPositionName() + "," + p.getPositionDuty() + "," + p.getPositionIDU());
			}
		}
	}
	
	//return a position found through its ID 
	@Test
	public void testGetPositionFromID() {
		int positionID = 1; 
		
		positionList = db.getPositionByID(positionID);
		
		if(positionList.isEmpty()) {
			System.out.println("There are no positions in this table you silly billy");
			fail("You must add more positions to test zis method");
		}
		else {
			List<Position> positions = new ArrayList<Position>();
			//return the found information that we wanted from the db
			for(Position p : positionList) {
				Position addpos = p;
				positions.add(addpos);
				System.out.println(p.getPositionIdS() + "," + p.getPositionName()+ "," + p.getPositionDuty()+ "," + p.getPositionIDU());
			}
		}
		
	}
	
	//get a position from its name, and return it as an object  
	@Test
	public void testGetPositionFromName() {
		String positionName = "Intern";
		
		positionList = db.getPositionInfo(positionName);
		
		if(positionList.isEmpty()) {
			System.out.println();
			fail();
		}
		else {
			List<Position> positions = new ArrayList<Position>();
			//return the found information that we want from the db
			for(Position p : positionList) {
				Position addpos = p;
				positions.add(addpos);
				System.out.println(p.getPositionName() + "," + p.getPositionDuty());
			}
		}
	}
	
	//need to add this method to the DB first 
	@Test
	public void testAddSOPtoPosition() {
		String sop = "Electronic Signature";
		String position = "Grunt";
		
		List<PositionSOP> positions = db.addSOPToPositions(sop, position);
		if(positions.isEmpty()) {
			
		}
		else {
			//resume working here when we have return statements 
			sopPositionList = new ArrayList<PositionSOP>();
			for(PositionSOP sp : positions) {
				sopPositionList.add(sp);
				System.out.println(sp.getPositionID() + ", " + sp.getSopID());
			}
		}
		
	}
	
	//this could possibly be done in the servlets/controllers 
	@Test
	public void addUserTOPoisition() {
		String position = "Watch Commander";
		String user = "Jsnow";
		List<UserPosition> positions = db.addPositionToUser(user, position);
		
		
		if(positions.isEmpty()) {
			System.out.println("I can't let you do that 'insert username here'");
			fail("Would you like to play a game?");
		}
		else {
			userPositionList = new ArrayList<UserPosition>();
			for(UserPosition up: positions) {
				userPositionList.add(up);
				System.out.println(up.getUserID()+", "+ up.getPositionID());
			}
		}
	}
	
	//influenced by the Lab 6 library example
	//get all users in the DB
	@Test
	public void testGetAllUsers() {
		List<User> userList = db.findAllUsers(); 
		if(userList.isEmpty()) {
			System.out.println("There are no users in the database");
			fail("Fix the problem!");
		}
		else {
			List<User> users = new ArrayList<User>();
			for(User user: userList) {
				users.add(user);
				System.out.println(user.getFirstName() + ", "+ user.getLastName() + " , "+ user.getUserID() + " , "+  user.getUsername() + " , "+ user.getEmailAddress());
			}
		}
		
	}
	
	//return all sops in the DB
	@Test
	public void testGetAllSSOPs() {
		List<SOP> sops = db.findAllSOPs();
		
		if(sops.isEmpty()) {
			System.out.println("There are no SOPs in the databse");
			fail("Knock knock: this is the FDA");
		}
		else {
			sopList = new ArrayList<SOP>();
			for(SOP s : sops) {
				sopList.add(s);
				System.out.println(s.getSopName() + " , "+  s.getSopIdNumber() + " , "+ s.getPriority() + " , "+ s.getRevision());
			}
		}
	}
	
	//return all positions in the DB
	@Test
	public void testGetAllPositions() {
		List<Position> positions = new ArrayList<Position>();
		
		if(positions.isEmpty()) {
			System.out.println("There are no positions in the database");
			fail("Don't you think that you should, I don't know, have positions availible?");
		}
		else {
			positionList = new ArrayList<Position>();
			for(Position p: positions) {
				positionList.add(p);
				System.out.println(p.getPositionIdS() + " , "+ p.getPositionName() + " , "+ p.getPositionDuty());
			}
		}
	}
	
	//search for a user based on their last name 
	@Test
	public void getUserByLastName() {
		String lastname = "Fawlty";
		List<User> users = db.findUserByLastName(lastname);
		
		if(users.isEmpty()) {
			System.out.println("There are no users in the Database with that last name");
			fail("If you would like, I could ring up my man Manuel");
		}
		else {
			userList = new ArrayList<User>();
			for(User user: users) {
				userList.add(user);
				System.out.println(user.getFirstName() + " , "+ user.getLastName() + " , "+ user.getUsername() + " , "+ user.getUserID() + " , "+ user.getEmailAddress());
			}
		}
		
		
	}
	
	//find a position by the name of the position
	@Test
	public void getPositionByNametest() {
		String positionName = "Intern";
		
		List<Position> positions = db.findPositionByName(positionName);
		
		if(positions.isEmpty()) {
			System.out.println("I'm afraid the class you are searching for does not exist");
			fail("Now witness the power of this fully operational system");
		}
		else {
			positionList = new ArrayList<Position>();
			for(Position p : positions) {
				
				positionList.add(p);
				
				System.out.println(p.getPositionName() +", " + p.getPositionDuty());
			}
		}
	}
	
	//TODO: space for training history methods 
}
