package ycp.cs320.teamProject.model;

//import java.util.Random;

public class User {

		private int UserID;
		private String Username;
		private String Password;
		private String firstName;
		private String lastName; 
		private String emailAddress;
		
		private String isAdmin;
		private boolean loginStatus = false;
		
		//will act as a first time user in other programs 
		private boolean electronicSignatureFlag = false;
		
		//I think this should be the same as the employee number, not random, will also help to search by emp. #
		//to generate a unique user ID
		public User(){
			
		}
		
		public void setUserNumber(int EmpNumb){
			this.UserID = EmpNumb;
		}
		
		public void setUserAccountInformation(String fn, String ln, String email) {
			this.firstName = fn;
			this.lastName = ln;
			this.emailAddress = email;
		}
		
		public boolean authenticate(String Username, String  password) {
			
			//right now use this as a placeholder. 
			return false;
		}
		
		public boolean logIn(String Username, String password){
			//working with authenticate in the controller 
			if(loginStatus != true) {
				loginStatus = true; 
				
				//this will be modified later to coincide with completing the training 
				//probably set this up in a controller 
				//electronicSignatureFlag = true;
			}
			
			return loginStatus;
		}
		
		//auto generated getter and setter methods 
		public int getUserID() {
			return UserID;
		}

		public void setUserID(int userID) {
			UserID = userID;
		}

		public String getUsername() {
			return Username;
		}

		public void setUsername(String username) {
			Username = username;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}


		public String isAdmin() {
			return isAdmin;
		}

		public void setAdmin(String isAdmin) {
			this.isAdmin = isAdmin;
		}

		public boolean isElectronicSignatureFlag() {
			return electronicSignatureFlag;
		}

		public void setElectronicSignatureFlag(boolean electronicSignatureFlag) {
			this.electronicSignatureFlag = electronicSignatureFlag;
		}
}
