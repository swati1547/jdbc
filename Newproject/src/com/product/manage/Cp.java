package com.product.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cp {
	
	static Connection con; 
	public static Connection createC() {
		try {
			
			
//			Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
//			connecction
//			String url = "jdbc:mysql://localhost:3306/product";
//			String user = "root";
//			String password = "TIGER";
			
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/product", "root", "TIGER");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return con;
	}
}
