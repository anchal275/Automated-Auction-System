package com.auction.bean;

public class Sold {
	
	private int SitemId;  
	private String SName; 
	private int Price; 
	private int Quantity;  
	private String Category;  
	private int BuyerID;
	
	
	@Override
	public String toString() {
		return "Sold [SitemId=" + SitemId + ", SName=" + SName + ", Price=" + Price + ", Quantity=" + Quantity
				+ ", Category=" + Category + ", BuyerID=" + BuyerID + "]";
	}
	
	
	public Sold(int sitemId, String sName, int price, int quantity, String category, int buyerID) {
		super();
		SitemId = sitemId;
		SName = sName;
		Price = price;
		Quantity = quantity;
		Category = category;
		BuyerID = buyerID;
	}
	
	
	public Sold() {
		super();
	}
	
	
	public int getSitemId() {
		return SitemId;
	}
	public void setSitemId(int sitemId) {
		SitemId = sitemId;
	}
	public String getSName() {
		return SName;
	}
	public void setSName(String sName) {
		SName = sName;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getBuyerID() {
		return BuyerID;
	}
	public void setBuyerID(int buyerID) {
		BuyerID = buyerID;
	}
	
	
	
	
	
	
	
	
	

}
