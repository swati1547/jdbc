package com.product.manage;

public class Product {

	
	private int productID;
	private String productName;
	private String producttype;
	private String productCategory;
	private int productPrice;
	
	
	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

	public Product(int productID, String productName, String producttype, String productCategory, int productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.producttype = producttype;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}

	public Product(String productName, String producttype, String productCategory, int productPrice) {
		super();
		this.productName = productName;
		this.producttype = producttype;
		this.productCategory = productCategory;
		this.productPrice = productPrice;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", producttype=" + producttype
				+ ", productCategory=" + productCategory + ", productPrice=" + productPrice + "]";
	}

}
