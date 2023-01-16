package com.product.manage;

import java.util.Scanner;

public class Producttable {
	public static void ProductTable() {
		
		Scanner me = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
		while(true) {
			
			System.out.println("press 1 to add product");
			System.out.println("press 2 to delete product");
			System.out.println("press 3 to display all products");
			System.out.println("press 4 to update record");
			System.out.println("press 5 to exit app");
			int c = me.nextInt();
			
			if(c == 1)
			{
//				add product
				
				System.out.println("Enter product Id");
				int id = me.nextInt();
					
				System.out.println("Enter product name");
				String name = input.nextLine();
				
				System.out.println("enter product Type");
				String type = input.nextLine();
				
				System.out.println("enter product Category");
				String category = input.nextLine();
						
				System.out.println("enter product Price");
				int price = me.nextInt();
				
				Product pro = new Product( id , name, type, category, price);
				System.out.println(pro);
				
				boolean answer = Insertproduct.insertProducttoDB(pro);
				if (answer) {
					System.out.println("product added successfully..");
				}else {
					System.out.println("something went wrong try again");
				}
			}
			else if (c==2) {
//				delete product
				System.out.println("Enter product ID to delete: ");
				int productID = me.nextInt();
				boolean state1= Insertproduct.deleteProduct(productID);
				if (state1) {
					System.out.println("product deleted successfully..");
				}else {
					System.out.println("something went wrong try again");
				}
			}
			
			else if (c==3) {
//				display products
				Insertproduct.showAllProduct();
				
			}
			
			else if (c==4) {
				Insertproduct.updateProduct();
			}
			
			else if (c==5) {
//				exit
				break;
			}
			
			else {
				
			}
			
			}
	}
}
