package com.product.manage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AllProduct {
	public static void Allproducts() {
			try {
//				jdbc code
				Connection con = Cp.createC();
				String q= "select * from product, price where product.Product_Category=price.Product_Category";
//				prepared statment
				Statement stmt = con.createStatement();
				ResultSet set = stmt.executeQuery(q);
				
				while(set.next())
				{
					int id = set.getInt(1);
					String name=set.getString(2);
					String type =set.getString(3);
					String category =set.getString(4);
					int price = set.getInt(5);
					int discount = set.getInt(7);
					float dis = (discount * price)/100;
//					discount = 
					int gst = set.getInt(8);
					float gst1 =  (gst * (price-discount))/100;
//					gst =
					int deliverycharge = set.getInt(9);
					
					System.out.println("productId : " + id);
					System.out.println("name : " + name);
					System.out.println("productType : " + type);
					System.out.println("category : " + category);
					System.out.println("basePrice : " + price);
					System.out.println("discount : " + dis);
					
					
					
					String charge1 = "gst : " + gst1;
					String charge2 = "delivery : " + deliverycharge;
					System.out.println("charges : {" + charge1 + ", " + charge2 + "}");
//					System.out.println("product gst : " + gst);
					
					float finalprice = (price - dis)+ gst1 + deliverycharge; 
					System.out.println("finalPrice : " + finalprice);
					System.out.println("-----------------------------------");
				}
				
			}catch(Exception e){
					e.printStackTrace();
			}
	
	}
}
