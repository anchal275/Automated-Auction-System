package com.auction.Dao;

import java.util.List;
import com.auction.bean.Item;
import com.auction.bean.Seller;
import com.auction.bean.Sold;
import com.auction.exceptions.SellerException;

public interface SellerDao {
	
	public String registerSeller(Seller seller);
	
	public Seller loginSeller(String username, String password) throws SellerException;
	
    public String AddItemToSell(Item item);
    
    public String removeItem(int ItemId);
    
    public List<Item> ShowItemOfSeller(int SellerId);
    
    public List<Sold> getSoldList();
    
    
}
