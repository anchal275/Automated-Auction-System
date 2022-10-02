package com.auction.Dao;

import java.util.List;

import com.auction.bean.Buyer;
import com.auction.bean.Item;
import com.auction.exceptions.BuyerException;


public interface BuyerDao {
	
	public String registerBuyer(Buyer buyer);
	
	public Buyer loginBuyer(String username, String password) throws BuyerException;
	
	public List<Item> searchByCategory(String Category) throws BuyerException;
	
	public List<String> showCategory();
	
	public List<Item> showItem();
	
	public Item buyItem(int itemId);
	
	public void ItemPurchase(Item item,int BuyerID);
	
	
	
}
