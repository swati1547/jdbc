package com.product.manage;

public class Price {

	
	private String category;
	private int discount;
	private int gst;
	private int deliverycharge;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getGst() {
		return gst;
	}

	public void setGst(int gst) {
		this.gst = gst;
	}

	public int getDeliverycharge() {
		return deliverycharge;
	}

	public void setDeliverycharge(int deliverycharge) {
		this.deliverycharge = deliverycharge;
	}

	public Price(String category, int discount, int gst, int deliverycharge) {
		super();
		this.category = category;
		this.discount = discount;
		this.gst = gst;
		this.deliverycharge = deliverycharge;
	}

	@Override
	public String toString() {
		return "Price [category=" + category + ", discount=" + discount + ", gst=" + gst + ", deliverycharge="
				+ deliverycharge + "]";
	}

}
