package com.product.manage;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

public class CategoryToDb {
	private static Scanner no = new Scanner(System.in);
	private static Scanner input = new Scanner(System.in);
	
	public static boolean categoryToDB(Price pr) {
		
		boolean f=false;
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "insert into price values(?,?,?,?)";
//			prepared statment
			PreparedStatement pstmt = con.prepareStatement(q);
//			set the value of parameter
			pstmt.setString(1, pr.getCategory());
			pstmt.setInt(2, pr.getDiscount());
			pstmt.setInt(3, pr.getGst());
			pstmt.setInt(4, pr.getDeliverycharge());
			
//			execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
				e.printStackTrace();
		}
		return f;
	}
	
	public static boolean deleteCategory(String prodCat) {
		boolean f=false;
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "delete from price where Product_Category= ? ";
//			prepared statment
			PreparedStatement pstmt = con.prepareStatement(q);
//			set the value of parameter
			pstmt.setString(1, prodCat);
			
//			execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
				e.printStackTrace();
		}
		return f;
	}
//	
	
	public static void showAllCategory() {
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "select * from price";
//			prepared statment
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				String category = set.getString(1);
				int dis=set.getInt(2);
				int gst =set.getInt(3);
				int delChrg =set.getInt(4);
				
				System.out.println("product category : " + category);
				System.out.println("product discount : " + dis);
				System.out.println("product gst : " + gst);
				System.out.println("product delivery charges : " + delChrg);
				System.out.println("-----------------------------------");
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}
	}

	public static void updateCategory() {	
		
		try {
			Connection con = Cp.createC();
			System.out.println("Enter product category to update record : ");
			String catName = no.nextLine();
			
			String q = "select * from price where Product_Category = " + catName;
			
			Statement stmt = con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			
			if(set.next()) {
				String category = set.getString(1);
				int dis=set.getInt(2);
				int gst =set.getInt(3);
				int delChrg =set.getInt(4);
				
				System.out.println("product category : " + category);
				System.out.println("product discount : " + dis);
				System.out.println("product gst : " + gst);
				System.out.println("product delivery charges : " + delChrg);
				System.out.println("-----------------------------------");
				
				System.out.println("what do you want to update?");
				System.out.println("1.Product discount");
				System.out.println("2.Product gst");
				System.out.println("3.Product delivery charges");
				int choice = no.nextInt();
				
				String sqlQuery = "update price set ";
				switch(choice) {
				case 1: 
					System.out.println("Enter new category : ");
					int newDis = input.nextInt();
					sqlQuery = sqlQuery + "Discount = ? where Product_category = " + catName;
					PreparedStatement pstmt = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt.setInt(1, newDis);
					int rows = pstmt.executeUpdate();
					if (rows>0){
						System.out.println("category updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				case 2:
					System.out.println("Enter new GST : ");
					int newGst = input.nextInt();
					sqlQuery = sqlQuery + "GST = ? where Product_category = " + catName;
					PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt1.setInt(1, newGst);
					int rows1 = pstmt1.executeUpdate();
					if (rows1>0){
						System.out.println("category updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				case 3:
					System.out.println("Enter new delivery charges : ");
					int newDelchrg = input.nextInt();
					sqlQuery = sqlQuery + "GST = ? where Product_category = " + catName;
					PreparedStatement pstmt2 = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt2.setInt(1, newDelchrg);
					int rows2 = pstmt2.executeUpdate();
					if (rows2>0){
						System.out.println("category updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				}
				
			}else {
				System.out.println("records not found");
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}
	}
	
}























