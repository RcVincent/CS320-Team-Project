package ycp.cs320.teamProject.model;

//import java.util.Random;

public class MileStone1_User {

		private int UserID = 0013;
		private String Username = "JSnow";
		private String Password = "Winter1sComing";
		private String firstName = "John";
		private String lastName = "Snow"; 
		private String emailAddress = "KingOfTheNorth@CastleBlack.com";
		
		
		private boolean isAdmin = true;//you bet the lord commander is an Admin
		private boolean loginStatus = true;
		

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


		public boolean isAdmin() {
			return isAdmin;
		}

		public void setAdmin(boolean isAdmin) {
			this.isAdmin = isAdmin;
		}
}
