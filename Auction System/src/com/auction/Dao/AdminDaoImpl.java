package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.bean.Admin;
import com.auction.bean.Buyer;
import com.auction.bean.Seller;
import com.auction.bean.Sold;
import com.auction.exceptions.AdminException;
import com.auction.utility.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		Admin admin = null;
	    
	    
	    try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = 
	    conn.prepareStatement("Select * from Admin Where email = ? AND password = ?");
	    
	    ps.setString(1, username);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	int id = rs.getInt("adminID");
	    	String name = rs.getString("name");
	    	String email = rs.getString("email");
	    	String pass = rs.getString("password");
	    	admin = new Admin(id, name, email, pass);
	    	
	    }else {
	      throw new AdminException("Invalid Username or Password");
	    }
	    
	    
		} catch (SQLException e) {
		  throw new AdminException(e.getMessage());
		}
	
	    
		return admin;
	}

	@Override
	public List<Seller> getSellerList() {
		List<Seller> ls = new ArrayList<>();
	try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = conn.prepareStatement("Select * from Seller");
	    ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		int id = rs.getInt("SellerID");
		String n = rs.getString("Sname");
		String e = rs.getString("Semail");
		String p = rs.getString("Spassword");
		Seller seller = new Seller(id, n, e, p);
		ls.add(seller);
	}
			
	} catch (SQLException e) {
	  System.out.println(e.getMessage());
	}
	 return ls;
	}

	@Override
	public List<Buyer> getBuyerList() {
	List<Buyer> lb = new ArrayList<>();
	try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = conn.prepareStatement("Select * from Buyer");
	    ResultSet rs = ps.executeQuery();
	while(rs.next()) {
		int id = rs.getInt("BuyerID");
		String n = rs.getString("Bname");
		String e = rs.getString("Bemail");
		String p = rs.getString("Bpassword");
		Buyer buyer = new Buyer(id, n, e, p);
		lb.add(buyer);
	}
			
	} catch (SQLException e) {
	  System.out.println(e.getMessage());
	}
	 return lb;
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
