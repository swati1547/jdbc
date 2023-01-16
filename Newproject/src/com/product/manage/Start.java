package com.product.manage;

import java.util.Scanner;
//import java.sql.Connection;
//import java.sql.DriverManager;

public class Start {
	
//	private static Connection connection = null;
	
	public static void main(String[] args) {
		
		System.out.println("welcome");
		 Scanner br = new Scanner(System.in);
		 
		 System.out.println("which table do you want to handle : ");
		 System.out.println("1.products");
		 System.out.println("2.Categories & charges");
		 System.out.println("3.Show all Products details");
		 int choose = br.nextInt();
		 
		 switch(choose) {
		 case 1: Producttable.ProductTable();
		 break;
		 case 2: Category.Charges();
		 break;
		 case 3: AllProduct.Allproducts();
		 }
		
		
		System.out.println("thank you");
			
	}
}
