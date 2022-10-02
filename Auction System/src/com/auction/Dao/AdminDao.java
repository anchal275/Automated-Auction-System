package com.auction.Dao;

import java.util.List;

import com.auction.bean.Admin;
import com.auction.bean.Buyer;
import com.auction.bean.Seller;
import com.auction.bean.Sold;
import com.auction.exceptions.AdminException;

public interface AdminDao {
	
	public Admin loginAdmin(String username, String password) throws AdminException;
	
	public List<Seller> getSellerList();
	
	public List<Buyer> getBuyerList();
	
	public List<Sold> getSoldList();
	
 	
}
