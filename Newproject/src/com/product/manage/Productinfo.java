package com.product.manage;

import java.sql.*;
import java.util.Scanner; 

public class Productinfo {
	private static Connection myConn = null;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {

		Productinfo insertnewrecord = new Productinfo();
		
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
			// 1. Get a connection to database
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login_user", "student" , "student");
			
			System.out.println("Database connection successful!\n");
			System.out.println("Enter choice");
			System.out.println("inter a record");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice) {
			case 1: insertnewrecord.insertrecord();
			break;
			}
					
			// 3. Execute SQL query
//			myRs = myStmt.executeQuery("select * from register_user");
//			myStmt.execute("insert into register_user values('garje','garjeeee@1', '123','1234567071')");
			
			// 4. Process the result set
//			while (myRs.next()) {
//				System.out.println(myRs.getString("username") + ", " + myRs.getString("email"));
//			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}
	
	public static void insertrecord() throws SQLException {
		System.out.println("inside insert record");
		
		String sql = "insert into register_user values(?,?,?,?)";
		// 2. Create a statement
//					myStmt = myConn.createStatement();
		
		PreparedStatement preparestmnt = myConn.prepareStatement(sql);
		System.out.println("enter a name:");
		preparestmnt.setString(1, sc.nextLine());
		System.out.println("enter a mail:");
		preparestmnt.setString(2, sc.nextLine());
		System.out.println("enter a password:");
		preparestmnt.setString(3, sc.nextLine());
		System.out.println("enter a contact number:");
		preparestmnt.setString(4, sc.nextLine());
		preparestmnt.executeUpdate();
	}

}
