package com.product.manage;

import java.util.Scanner;

public class Category {
	public static void Charges() {
		System.out.println("i am charges");
		
		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);
		while(true) {
			
			System.out.println("press 1 to add category");
			System.out.println("press 2 to delete category");
			System.out.println("press 3 to display all category");
			System.out.println("press 4 to update category record");
			System.out.println("press 5 to exit app");
			int c = input.nextInt();
			
			if(c == 1)
			{
//				add product
				
				System.out.println("Enter product category");
				String category = input2.nextLine();
					
				System.out.println("Enter Discount");
				int dis = input.nextInt();
				
				System.out.println("Enter GST");
				int gst = input.nextInt();
				
				System.out.println("enter delivery charges");
				int chrg = input.nextInt();

				Price pr = new Price(category, dis, gst, chrg);
				System.out.println(pr);
				
				boolean answer = CategoryToDb.categoryToDB(pr);
				if (answer) {
					System.out.println("product added successfully..");
				}else {
					System.out.println("something went wrong try again");
				}
			}
			else if (c==2) {
//				delete product
				System.out.println("Enter product category to delete: ");
				String prodCat = input2.nextLine();
				boolean state1= CategoryToDb.deleteCategory(prodCat);
				if (state1) {
					System.out.println("product deleted successfully..");
				}else {
					System.out.println("something went wrong try again");
				}
			}
			
			else if (c==3) {
//				display products
				CategoryToDb.showAllCategory();
				
			}
			
			else if (c==4) {
				CategoryToDb.updateCategory();
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

