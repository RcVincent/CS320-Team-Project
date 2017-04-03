package controller;
import static org.junit.Assert.*;

import java.util.ArrayList;

import ycp.cs320.teamProject.DBpersist.*;
import ycp.cs320.teamProject.model.*;
import org.junit.Before;
import org.junit.Test;

import ycp.cs320.teamProject.controllers.Projectcontroller;;
public class ControllerTests {
	private Projectcontroller controller;
	 private User Admin = new User(); 
	 private String AdminUserName = "User"; 
	 private String AdminPassword = "Pa55w0rd";
	 private String AdminFN ="Ad";
	 private String AdminLN = "Min";
	 private String AdminEmail = "Admin@email";
	 private int AdminUserNum =10110;
	 private User Normie = new User();
	 private String NormieUserName = "BoringPerson";
	 private String NormiePassword = "Pickles";
	 private ArrayList<User> Users;
	
	 @Before
	 public void setUp() {
		 Admin.setUserAccountInformation("Ad", "Min", "Admin@email");
		 Admin.setPassword(AdminPassword);
		 Admin.setUsername(AdminUserName);
		 Admin.setUserID(1);
		 Admin.setUserNumber(10110);
		 Admin.setElectronicSignatureFlag(true);
		 Admin.setAdmin(AdminUserName);
		 Admin.setUserAccountInformation(AdminFN, AdminLN, AdminEmail);
		 Normie.setEmailAddress("Normie@email.com");
		 Normie.setFirstName("NormiefirstName");
		 Normie.setLastName("NormielastName");
		 Normie.setPassword(NormiePassword);
		 Normie.setUsername(NormieUserName);
		 Normie.setUserID(2);
		 Normie.setUserNumber(01001);
		 Normie.setElectronicSignatureFlag(false);
		 Users.add(Admin);
		 Users.add(Normie);
	 }
	 
	 @Test
	 public void testMatchUserNameWithPassword(String username){
		 
	 }
	 
	 @Test
	 public void testgetAccountInformation(String username){
		 
	 }
	
	 @Test
	 public void changeUserPassword(String Username, String oldpassword, String newpassword){
		 
	 }
	
	 @Test
	 public void changeUsername(String Username, String newUsername, String password)  {
		 
	 }
	
	 @Test
	 public void addUserToDatabase(String userName, String passWord, String email, String type, String firstName, String lastname) {
		 
	 }
	 
}
