package controller;
import static org.junit.Assert.*;
import ycp.cs320.teamProject.DBpersist.*;
import ycp.cs320.teamProject.model.*;
import org.junit.Before;
import org.junit.Test;

import ycp.cs320.teamProject.controllers.Projectcontroller;;
public class ControllerTests {
	private Projectcontroller controller;
	 private String rightUserName = "user1";
	 private String wrongUserName = "UsEr!";
	 private String rightPassword = "Pa55w0rd";
	 private String wrongPassword = "Pickles";
	 private IDatabase MYdata;
	 //Wondering if i can compare the derby data results
	 //to that of a fake database that is more easily
	 //accessible
	 @Before
	 public void setUp() {
		DatabaseProvider.setInstance(new DerbyDatabase());
		MYdata = DatabaseProvider.getInstance();	
		
	 }
}
