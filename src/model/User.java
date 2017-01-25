package model;

import java.util.Random;

public class User {

		private int UserID;
		private String Username;
		private String Password;
		private String firstName;
		private String lastName; 
		private String emailAddress;
		
		private boolean accountType;
		private boolean loginStatus = false;
		
		//to generate a unique user ID
		Random rand;
		
		public User(){
			this.rand = new Random();
			setUserID(rand.nextInt(900000000));
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

		public boolean isAccountType() {
			return accountType;
		}

		public void setAccountType(boolean accountType) {
			this.accountType = accountType;
		}
}
