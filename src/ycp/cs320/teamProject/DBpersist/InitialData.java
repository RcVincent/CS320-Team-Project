package ycp.cs320.teamProject.DBpersist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ycp.cs320.teamProject.DBpersist.ReadCSV;
import ycp.cs320.teamProject.model.*;

public class InitialData {
	
		//user db will be for authentication and hold a primary key for users and admins
		public static List<User> getUsers() throws IOException {
			//read the users file
			List<User> userList = new ArrayList<User>();
			ReadCSV readUser = new ReadCSV("Users.csv");
			
			try {
				// auto-generated primary key for table User
				Integer userId = 1;
				while (true) {
					List<String> tuple = readUser.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					User user = new User();

					// read User ID from CSV file, but don't use it
					// auto-generate User ID, instead
					user.setUserID(userId++);				
					user.setUsername(i.next());
					user.setPassword(i.next());
					user.setEmailAddress(i.next());
					user.setAdmin(i.next());
					user.setFirstName(i.next());
					user.setLastName(i.next());
					userList.add(user);
				}
			
				System.out.println("UserList loaded from CSV file");	
				return userList;
			} finally {
				readUser.close();
			}
		}
		
		//Sop db will be for authentication and hold primary key for users and admins 
		public static List<SOP> getSOPs() throws IOException {
			
			//read the SOPs file
			List<SOP> sopList = new ArrayList<SOP>();
			ReadCSV readSOP = new ReadCSV("SOPs.csv");
			
			try {
				Integer sopId = 1;
				while(true) {
					List<String> tuple = readSOP.next();
					if(tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					SOP sop = new SOP();
					
					sop.setSopIdNumber(sopId++);
					sop.setSopName(i.next());
					sop.setAuthorIDnumber(i.next());
					sop.setSopAuthorFirstname(i.next());
					sop.setSopAuthorLastname(i.next());
					sop.setPriority(i.next());
					sop.setRevision(i.next());
					
					sopList.add(sop);
					
				}
				System.out.println("SOPList loaded from the CSV file");
				return sopList;
			}
			finally {
				readSOP.close();
			}
		}
		
		//space for the position method 
		
}
