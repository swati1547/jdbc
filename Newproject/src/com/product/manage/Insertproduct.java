package com.product.manage;
//import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.Scanner;

public class Insertproduct {
	private static Scanner no = new Scanner(System.in);
	private static Scanner input = new Scanner(System.in);
	
	public static boolean insertProducttoDB(Product pro) {
		
		boolean f=false;
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "insert into product values(?,?,?,?,?)";
//			prepared statment
			PreparedStatement pstmt = con.prepareStatement(q);
//			set the value of parameter
			pstmt.setInt(1, pro.getProductID());
			pstmt.setString(2, pro.getProductName());
			pstmt.setString(3, pro.getProducttype());
			pstmt.setString(4, pro.getProductCategory());
			pstmt.setInt(5, pro.getProductPrice());
			
//			execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
				e.printStackTrace();
		}
		return f;
	}
	
	public static boolean deleteProduct(int productID) {
		boolean f=false;
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "delete from product where Product_ID=?";
//			prepared statment
			PreparedStatement pstmt = con.prepareStatement(q);
//			set the value of parameter
			pstmt.setInt(1, productID);
			
//			execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e){
				e.printStackTrace();
		}
		return f;
	}
	
	
	public static void showAllProduct() {
		
		try {
//			jdbc code
			Connection con = Cp.createC();
			String q= "select * from product";
//			prepared statment
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			while(set.next())
			{
				int id = set.getInt(1);
				String name=set.getString(2);
				String type =set.getString(3);
				String category =set.getString(4);
				String price = set.getString(5);
				
				System.out.println("product id : " + id);
				System.out.println("product name : " + name);
				System.out.println("product type : " + type);
				System.out.println("product category : " + category);
				System.out.println("product price : " + price);
				System.out.println("-----------------------------------");
			}
			
		}catch(Exception e){
				e.printStackTrace();
		}
	}

	public static void updateProduct() {
		System.out.println("i am running");
		
		
		try {
			System.out.println("Enter id to update record : ");
			int proid = no.nextInt();
			
			String q = "select * from product where Product_ID = " + proid;
			Connection con = Cp.createC();
//			prepared statment
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			
			if(set.next()) {
				int id = set.getInt(1);
				String name=set.getString(2);
				String type =set.getString(3);
				String category =set.getString(4);
				String price = set.getString(5);
				
				System.out.println("product id : " + id);
				System.out.println("product name : " + name);
				System.out.println("product type : " + type);
				System.out.println("product category : " + category);
				System.out.println("product price : " + price);
				System.out.println("-----------------------------------");
				
				System.out.println("what do you want to update?");
				System.out.println("1.Product Name");
				System.out.println("2.Product Type");
				System.out.println("3.Product Category");
				System.out.println("4.Product Price");
				int choice = no.nextInt();
				
				String sqlQuery = "update product set ";
				switch(choice) {
				case 1: 
					System.out.println("Enter new Name : ");
					String newname = input.nextLine();
					sqlQuery = sqlQuery + "Product_Name = ? where Product_ID = " + proid;
					PreparedStatement pstmt = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt.setString(1, newname);
					int rows = pstmt.executeUpdate();
					if (rows>0){
						System.out.println("product updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				case 2:
					System.out.println("Enter new type : ");
					String newType = input.nextLine();
					sqlQuery = sqlQuery + "Product_Type = ? where Product_ID = " + proid;
					PreparedStatement pstmt1 = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt1.setString(1, newType);
					int rows1 = pstmt1.executeUpdate();
					if (rows1>0){
						System.out.println("product updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				case 3:
					System.out.println("Enter new category : ");
					String newCategory = input.nextLine();
					sqlQuery = sqlQuery + "Product_Category = ? where Product_ID = " + proid;
					PreparedStatement pstmt2 = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt2.setString(1, newCategory);
					int rows2 = pstmt2.executeUpdate();
					if (rows2>0){
						System.out.println("product updated successfully..");
					}else {
						System.out.println("something went wrong try again");
					}
					break;
					
				case 4:
					System.out.println("Enter new Price : ");
					int newPrice = input.nextInt();
					sqlQuery = sqlQuery + "Product_Price = ? where Product_ID = " + proid;
					PreparedStatement pstmt3 = con.prepareStatement(sqlQuery);
//					set the value of parameter
					pstmt3.setInt(1, newPrice);
					int rows3 = pstmt3.executeUpdate();
					if (rows3>0){
						System.out.println("product updated successfully..");
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























