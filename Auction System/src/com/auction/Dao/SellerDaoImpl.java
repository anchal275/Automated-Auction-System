package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.bean.Item;
import com.auction.bean.Seller;
import com.auction.bean.Sold;
import com.auction.exceptions.SellerException;
import com.auction.utility.DBUtil;


public class SellerDaoImpl implements SellerDao{

	@Override
	public String registerSeller(Seller seller) {
	    String message = "Seller Not Inserted";
	    
	try(Connection conn = DBUtil.ProvideConnection()) {
	PreparedStatement ps = 
	conn.prepareStatement("Insert into Seller(Sname,Semail,Spassword) values(?,?,?)");
	  
	ps.setString(1, seller.getSname());
	ps.setString(2, seller.getSemail());
	ps.setString(3, seller.getSpassword());
	
	int x = ps.executeUpdate();
     if(x>0) {	
    	 message = "Seller Registered Successfully";
    	 
     }	
	 
	} catch (SQLException e) {
		message = e.getMessage();
	}
	      
		return message;
	}

	@Override
	public Seller loginSeller(String username, String password) throws SellerException {
	    Seller seller = null;
	    
	    
	    try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = 
	    conn.prepareStatement("Select * from Seller Where Semail = ? AND Spassword = ?");
	    
	    ps.setString(1, username);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	int id = rs.getInt("SellerID");
	    	String name = rs.getString("Sname");
	    	String email = rs.getString("Semail");
	    	String pass = rs.getString("Spassword");
	    	seller = new Seller(id, name, email, pass);
	    	
	    }else {
	      throw new SellerException("Invalid Username or Password");
	    }
	    
	    
		} catch (SQLException e) {
		  throw new SellerException(e.getMessage());
		}
	
	    
		return seller;
	}

	@Override
	public String AddItemToSell(Item item) {
         String message = "Item not Added";
         try (Connection conn = DBUtil.ProvideConnection()){
         PreparedStatement ps = 
         conn.prepareStatement("Insert into Item(IName,Price,Quantity,Category,SellerID) values(?,?,?,?,?)");
         ps.setString(1, item.getIName());
     	 ps.setInt(2, item.getPrice());
     	 ps.setInt(3, item.getQuantity());
     	 ps.setString(4, item.getCategory());
    	 ps.setInt(5, item.getSellerID());
    	 
    	 int x = ps.executeUpdate();
         if(x>0) {	
        	 message = "Item Added Successfully";
         }	
    	} catch (SQLException e) {
    		message = e.getMessage();
    	}
         return message;
         
	}

	@Override
	public String removeItem(int ItemId) {
		String remove = null;
		try(Connection conn = DBUtil.ProvideConnection()){
			PreparedStatement ps =
			conn.prepareStatement("DELETE from Item Where ItemId = ?");
			ps.setInt(1, ItemId);
			
			int x = ps.executeUpdate();
			if(x>0) {
				remove = "Item Removed Successfully";
			}else {
				remove = "Item Does not Exist";
			}
			
		} catch (SQLException e) {
			remove = e.getMessage();
		}

		return remove;
	}

	@Override
	public List<Item> ShowItemOfSeller(int SellerId) {
		List<Item> li = new ArrayList<>();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from item where SellerID = ?");
	        ps.setInt(1, SellerId);
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ItemId");
			String n = rs.getString("IName");
			int p = rs.getInt("Price");
			int q = rs.getInt("Quantity");
			String c = rs.getString("Category");
			int sid = rs.getInt("SellerID");
			Item item = new Item(id, n, p, q, c, sid);
			li.add(item);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return li;
	}

	@Override
	public List<Sold> getSoldList() {
		List<Sold> ls = new ArrayList<>();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from Sold");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("SitemId");
			String n = rs.getString("SName");
			int p = rs.getInt("Price");
			int q = rs.getInt("Quantity");
			String c = rs.getString("Category");
			int bid = rs.getInt("BuyerID");
			Sold sold =  new Sold(id, n, p, q, c, bid);
			ls.add(sold);
		}
				
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return ls;
	
	}
}

