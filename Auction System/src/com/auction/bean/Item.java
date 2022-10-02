package com.auction.bean;

public class Item {
	
	private int ItemId;
	private String IName;
	private int Price;
	private int Quantity;
	private String Category;
	private int SellerID;
	
	public Item(int itemId, String iName, int price, int quantity, String category, int sellerID) {
		super();
		ItemId = itemId;
		IName = iName;
		Price = price;
		Quantity = quantity;
		Category = category;
		SellerID = sellerID;
	}

	public Item(String iName, int price, int quantity, String category, int sellerID) {
		super();
		IName = iName;
		Price = price;
		Quantity = quantity;
		Category = category;
		SellerID = sellerID;
	}

	public Item() {
		super();
	}

	public int getItemId() {
		return ItemId;
	}

	public void setItemId(int itemId) {
		ItemId = itemId;
	}

	public String getIName() {
		return IName;
	}

	public void setIName(String iName) {
		IName = iName;
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

	public int getSellerID() {
		return SellerID;
	}

	public void setSellerID(int sellerID) {
		SellerID = sellerID;
	}

	@Override
	public String toString() {
		return "Item [ItemId=" + ItemId + ", IName=" + IName + ", Price=" + Price + ", Quantity=" + Quantity
				+ ", Category=" + Category + ", SellerID=" + SellerID + "]";
	}
	
	
	
	
	

}
