package com.auction.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auction.bean.Buyer;
import com.auction.bean.Item;
import com.auction.exceptions.BuyerException;
import com.auction.utility.DBUtil;

public class BuyerDaoImpl implements BuyerDao{

	@Override
	public String registerBuyer(Buyer buyer) {
		 String message = "Buyer Not Inserted";
		 
		 try(Connection conn = DBUtil.ProvideConnection()) {
				PreparedStatement ps = 
				conn.prepareStatement("Insert into Buyer(Bname,Bemail,Bpassword) values(?,?,?)");
				
				ps.setString(1, buyer.getBname());
				ps.setString(2, buyer.getBemail());
				ps.setString(3, buyer.getBpassword());
				
				int x = ps.executeUpdate();
			     if(x>0) {	
			    	 message = "Buyer Registered Successfully";
			    	 
			    	 
			     }	
				 
				} catch (SQLException e) {
					message = e.getMessage();
				}
		return message;
	}
	
	
	

	@Override
	public Buyer loginBuyer(String username, String password) throws BuyerException {
    Buyer buyer = null;
	    
	    
	    try (Connection conn = DBUtil.ProvideConnection()){
	    PreparedStatement ps = 
	    conn.prepareStatement("Select * from Buyer Where Bemail = ? AND Bpassword = ?");
	    
	    ps.setString(1, username);
	    ps.setString(2, password);

	    ResultSet rs = ps.executeQuery();
	    
	    if(rs.next()) {
	    	int id = rs.getInt("BuyerID");
	    	String name = rs.getString("Bname");
	    	String email = rs.getString("Bemail");
	    	String pass = rs.getString("Bpassword");
	    	buyer = new Buyer(id, name, email, pass);
	    	
	    }else {
	      throw new BuyerException("Invalid Username or Password");
	    }
	    
	    
		} catch (SQLException e) {
		  throw new BuyerException(e.getMessage());
		}
	
	    
		return buyer;
	}




	@Override
	public List<Item> searchByCategory(String Category) throws BuyerException {
		List<Item> li = new ArrayList<>();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = 
		    conn.prepareStatement("select * from item Where Category = ?");
	        ps.setString(1, Category);
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
		  throw new BuyerException("Please choose the correct Category");
		}
		 return li;
	}




	@Override
	public List<String> showCategory() {
		List<String> lsc = new ArrayList<>();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = 
		    conn.prepareStatement("select Category from item group by category");
		    ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			String c = rs.getString("Category");
			lsc.add(c);
		}	
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		return lsc;
	}




	@Override
	public List<Item> showItem() {
		List<Item> li = new ArrayList<>();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from item");
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
	public Item buyItem(int itemId) {
		Item item = new Item();
		try (Connection conn = DBUtil.ProvideConnection()){
		    PreparedStatement ps = conn.prepareStatement("Select * from item where itemId = ?");
	        ps.setInt(1, itemId);
		    ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("ItemId");
			String n = rs.getString("IName");
			int p = rs.getInt("Price");
			int q = rs.getInt("Quantity");
			String c = rs.getString("Category");
			int sid = rs.getInt("SellerID");
			item = new Item(id, n, p, q, c, sid);
		}else {
			System.out.println("Please Enter correct Item Id");
		}
		} catch (SQLException e) {
		  System.out.println(e.getMessage());
		}
		 return item;
	}




	@Override
	public void ItemPurchase(Item item,int BuyerID) {
		 try(Connection conn = DBUtil.ProvideConnection()) {
				PreparedStatement ps = 
				conn.prepareStatement("Insert into Sold values(?,?,?,?,?,?)");
				
				ps.setInt(1, item.getItemId());
				ps.setString(2, item.getIName());
				ps.setInt(3, item.getPrice());
				ps.setInt(4,item.getQuantity());
				ps.setString(5, item.getCategory());
				ps.setInt(6,BuyerID);
				int x = ps.executeUpdate();
			     if(x>0) {	
			    	 System.out.println("Item Purchased Successfully");
			     }else {
			    	 System.out.println("Item Not Purchased");
			     }
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
	}
	
	
	
	





	
	
	

}
