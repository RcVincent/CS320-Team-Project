package ycp.cs320.teamProject.DBpersist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import sqldemo.DButil;
import ycp.cs320.teamProject.model.SOP;
import ycp.cs320.teamProject.model.User;


public class DerbyDatabase implements IDatabase {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 100;
	
	//Get user account Information
	@Override
	public List<User> getAccountInfo(final String name) {
		
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				try {
					stmt = conn.prepareStatement(
							" select * from Users " +
									" where user_userName = ? "
							);
					stmt.setString(1, name);
					List<User> result = new ArrayList<User>();
					resultSet = stmt.executeQuery();
					Boolean found = false;
					while (resultSet.next()) {
						found = true;

						User u = new User();
						loadUser(u, resultSet, 1);
						result.add(u);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + name + "> was not found in the Users table");
					}

					return result;


				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	//Match user with password, for the purposes of logging in and authentication
	@Override
	public List<User> matchUsernameWithPassword(final String name) {
		
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement(
							" select * from Users " +
									" where user_userName = ? "
							);
					stmt.setString(1, name);
					List<User> result = new ArrayList<User>();
					resultSet = stmt.executeQuery();

					// for testing that a result was returned
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						User u = new User();
						loadUser(u, resultSet, 1);
						result.add(u);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + name + "> was not found in the Users table");
					}

					return result;


				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}
	
	//Add a new user to the system 
	@Override
	public List<User> addUserToDatabase(final String name, final String pswd, final String email, final String type, final String first,
			final String last) {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				ResultSet resultSet = null;

				try {
					stmt = conn.prepareStatement(
							" insert into users(user_userName, user_passWord, user_email, user_accountType, user_firstName, user_lastName) " +
									" values(?, ?, ?, ?, ?, ?) "
							);
					stmt.setString(1, name);
					stmt.setString(2, pswd);
					stmt.setString(3, email);
					stmt.setString(4, type);
					stmt.setString(5, first);
					stmt.setString(6, last);
					stmt.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							" select * " +
									" from users " +
									" where user_userName = ?"
							);
					stmt2.setString(1, name);
					
					resultSet = stmt2.executeQuery();

					// for testing that a result was returned
					Boolean found = false;
					List<User> result = new ArrayList<User>();
					while (resultSet.next()) {
						found = true;
						User u = new User();
						loadUser(u, resultSet, 1);
						result.add(u);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + name + "> was not found in the users table");
					}

					return result;


				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	//this one may be tricky to work out 
	@Override
	public List<User> DeleteUserFromDatabase(final String name, final String pswd) {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null; 
				ResultSet resultSet = null;

				try {


					stmt = conn.prepareStatement(
							" delete from users " +
									" where user_userName = ? " +
									" and user_passWord = ? "
							);
					stmt.setString(1, name);
					stmt.setString(2, pswd);
					stmt.executeUpdate();

					// return all users and see that the one entered was deleted
					
					stmt2 = conn.prepareStatement(
							" select * from users " 		
							);
					resultSet = stmt2.executeQuery();
					List<User> result = new ArrayList<User>();
					
					Boolean found = false;

					while (resultSet.next()) {
						found = true;

						User u = new User();
						loadUser(u, resultSet, 1);
						result.add(u);
					}

					// check if the title was found
					if (!found) {
						System.out.println("<" + name + "> users list is empty");
					}

					return result;


				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	@Override
	public List<User> changePassword(final String name, final String pswd, final String newPassword) {
		return executeTransaction(new Transaction<List<User>>() {
			@Override
			public List<User> execute(Connection conn) throws SQLException {
				
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				
				ResultSet resultSet2 = null;
				
				try {
					
					stmt = conn.prepareStatement(
							" update users " +
									" set user_passWord = ? " +
									" where user_userName = ? " +
									" and user_passWord = ? "
							);

					stmt.setString(1, newPassword);
					stmt.setString(2, name);
					stmt.setString(3, pswd);
					stmt.executeUpdate();
					System.out.printf("Querry Completed: Update user's password");

					// return all users and see that the one entered was deleted
					
					stmt2 = conn.prepareStatement(
							" select * from users " 	+
									" where user_userName = ? "
							);
					//ensure new userName is in database
					stmt2.setString(1, newPassword);

					resultSet2 = stmt2.executeQuery();
					System.out.printf("Where does the query die?");

					List<User> result = new ArrayList<User>();
					
					Boolean found = false;

					while (resultSet2.next()) {
						found = true;

						User u = new User();
						loadUser(u, resultSet2, 1);
						result.add(u);
					}
					
					// check if the title was found
					if (!found) {
						System.out.println("<" + name + "> was not in users list");
					}

					return result;


				} finally {
					
					DBUtil.closeQuietly(resultSet2);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}
	
	/*
	//pull out the SOP requested 
	@Override
	public List<SOP> pullSOP(final int sopID) {
		return executeTransaction(new Transaction<List<SOP>>() {
			@Override
			public List<SOP> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							" select * from SOPs " +
							" where SOP_id = ? "	
							);
					stmt.setInt(1, sopID);
					System.out.print("");
					
					return null;
				}
				
				finally {
					DBUtil.closeQuietly(conn);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(resultSet);
				}
				
			}
		});
	}
	*/
	//add an SOP to the database 
	@Override
	public List<SOP> addSOP(final int sopID, final String sopName, final int authorID, final String authorName, final int priority, final int revision) {
		return executeTransaction(new Transaction<List<SOP>>() {
			@Override 
			public List<SOP> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							" insert into SOPs(sop_id, sop_Name, sop_authorID, sop_authorName, sop_priority, sop_revision) " +
									" values (?, ?, ?, ?, ?, ?) "
							
							);
					stmt.setInt(1, sopID);
					stmt.setString(2, sopName);
					stmt.setInt(3, authorID);
					stmt.setString(4, authorName);
					stmt.setInt(5, priority);
					stmt.setInt(6, revision);
					
					stmt.executeUpdate();
					
					stmt2 = conn.prepareStatement(
							" select * from sops " +
									" where sop_id = ? " + 
									" and sopName = ? " +
									" and sop_authorID = ? "
							);
					
					stmt2.setInt(1, sopID);
					stmt2.setString(2, sopName);
					stmt2.setInt(3, authorID);
					
					resultSet = stmt2.executeQuery();
					
					Boolean found = false;
					List<SOP> result = new ArrayList<SOP>();
					
					while(resultSet.next()) {
						found = true;
						SOP s = new SOP();
						loadSOP(s, resultSet, 1);
						result.add(s);
					}
					
					//check if the SOP was found
					if(!found) {
						System.out.println("<" + sopName + "was not found in the database" );
					}
					
					return result;
				}
				finally {
					DBUtil.closeQuietly(conn);
					DButil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(resultSet);
				}
			}
		});
	}
	
	//change the priority of an SOP in the DB
	//@Override
	public List<SOP> changePriority(final int sopID, final int newPriority){
		return executeTransaction(new Transaction<List<SOP>>() {
			@Override 
			public List<SOP> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				
				ResultSet resultSet = null;
				
				try {
					
				}
				
				finally {
					DBUtil.closeQuietly(conn);
					DButil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(resultSet);
				}
				
				
				return null;
				
			}
			
		});
	}
	
	//change the version number and 'edit' the SOP in the DB
	//@Override 
	public List<SOP> reviseSOP(final int sopID, final int newVersion) {
		return executeTransaction(new Transaction<List<SOP>>() {
			@Override 
			public List<SOP> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				PreparedStatement stmt2 = null;
				
				ResultSet resultSet = null;
				
				try {
					
				}
				
				finally {
					DBUtil.closeQuietly(conn);
					DButil.closeQuietly(stmt);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(resultSet);
				}
				return null;
				
			}
			
		});
	}
	
	
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}

	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();

		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;

			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}

			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}

			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:test.db;create=true");

		// Set autocommit to false to allow multiple the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);

		return conn;
	}
	
	//these build the collections to return to the servlets, controlles
	private void loadUser(User user, ResultSet resultSet, int index) throws SQLException {
		user.setUserID(resultSet.getInt(index++));
		user.setUsername(resultSet.getString(index++));
		user.setPassword(resultSet.getString(index++));
		user.setEmailAddress(resultSet.getString(index++));
		user.setAdmin(resultSet.getString(index++));
		user.setFirstName(resultSet.getString(index++));
		user.setLastName(resultSet.getString(index++));
	}
	
	private void loadSOP(SOP sop, ResultSet resultSet, int index) throws SQLException {
		sop.setSopIdNumber(resultSet.getInt(index++));
		sop.setSopName(resultSet.getString(index++));
		sop.setAuthorIDnumber(resultSet.getInt(index++));
		sop.setSOPAuthor(resultSet.getString(index++));
		sop.setPriority(resultSet.getInt(index++));
		sop.setRevision(resultSet.getInt(index++));
		//need to work out how to apply lists in SQL
		//sop.setPositionsAffected();
	}
	public void createTables() {
			executeTransaction(new Transaction<Boolean>() {
			
				@Override
				public Boolean execute(Connection conn) throws SQLException {
					PreparedStatement stmt1 = null;
					PreparedStatement stmt2 = null;
					try {
						stmt1 = conn.prepareStatement(
								" create table users ( " +
										"	user_id integer primary key " +
										"		generated always as identity (start with 1, increment by 1), " +									
										"	user_userName varchar(40),"     +
										"	user_passWord varchar(40), "     +
										"   user_email varchar(40), "        +
										"   user_accountType varchar(30), " +
										"    user_firstName varchar(50), "  +
										"    user_lastNAme varchar(50) "    +
										") "
								);	
						stmt1.executeUpdate();
						
						stmt2 = conn.prepareStatement(
								" create table sops (" +
										" sop_id integer primary key " +
										"	generated always as identity (start with 100, increment by 2), " +
										" sop_name varchar(40), " +
										" sop_authorID integer" +
										" sop_authorName varchar(40) "+
										" sop_priority integer" +
										" sop_revision integer " +
										") "
								);
						stmt2.executeUpdate();
						
						return true;
				
					} finally {
						DBUtil.closeQuietly(stmt1);
						DBUtil.closeQuietly(stmt2);
				
					}
				}	
		
			});
	}
	
	public void loadInitialData() {
		
	}
	
	
	// The main method creates the database tables and loads the initial data.
		public static void main(String[] args) throws IOException {
			System.out.println("Creating tables...");
			DerbyDatabase db = new DerbyDatabase();
			db.createTables();
			
			System.out.println("Loading initial data...");
			db.loadInitialData();
			
			System.out.println("Sucess!");
		}
}
