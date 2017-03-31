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
			List<User> UserList = new ArrayList<User>();
			ReadCSV readUser = new ReadCSV("Users.csv");
			
			try {
				// auto-generated primary key for table User
				Integer UserId = 1;
				while (true) {
					List<String> tuple = readUser.next();
					if (tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					User User = new User();

					// read User ID from CSV file, but don't use it
					// auto-generate User ID, instead
					User.setUserID(UserId++);				
					User.setUsername(i.next());
					User.setPassword(i.next());
					User.setEmailAddress(i.next());
					User.setAdmin(i.next());
					User.setFirstName(i.next());
					User.setLastName(i.next());
					UserList.add(User);
				}
			
				System.out.println("UserList loaded from CSV file");	
				return UserList;
			} finally {
				readUser.close();
			}
		}
		
		//Sop db will be for authentication and hold primary key for users and admins 
		public static List<SOP> getSOPs() throws IOException {
			
			//read the SOPs file
			List<SOP> SopList = new ArrayList<SOP>();
			ReadCSV readSOP = new ReadCSV("SOPs.csv");
			
			try {
				Integer SOPId = 1;
				while(true) {
					List<String> tuple = readSOP.next();
					if(tuple == null) {
						break;
					}
					Iterator<String> i = tuple.iterator();
					SOP sop = new SOP();
					
					sop.setSopIdNumber(SOPId++);
					sop.setSopName(i.next());
					sop.setAuthorIDnumber(i.next());
					sop.setSOPAuthor(i.next());
					sop.setPriority(i.next());
					sop.setRevision(i.next());
					
					SopList.add(sop);
					
				}
				System.out.println("SOPList loaded from the CSV file");
				return SopList;
			}
			finally {
				readSOP.close();
			}
		}
		
}
