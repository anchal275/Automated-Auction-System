package com.auction.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.auction.Dao.BuyerDao;
import com.auction.Dao.BuyerDaoImpl;
import com.auction.bean.Buyer;
import com.auction.bean.Item;
import com.auction.exceptions.BuyerException;

public class BuyerUsecases {
	
	public static Buyer BuyerloginUsecase() {
		Buyer buyer = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Buyer Username");
		String username = sc.next();
		
		System.out.println("Enter Buyer Password");
		String password = sc.next();
		
		BuyerDao Bdao = new BuyerDaoImpl();
		try {
			buyer = Bdao.loginBuyer(username, password);
			System.out.println("Welcome Buyer " + buyer.getBname());		
		} catch (BuyerException e) {
			System.out.println(e.getMessage());
		}
		return buyer;
	}
	
	
	
	public static String BuyerRegisterUsecase() {
		String register = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Buyer Name");
		String Bname = sc.next();
		
		System.out.println("Enter Buyer Email");
		String Bemail = sc.next();
		
		System.out.println("Enter Buyer Password");
		String Bpassword = sc.next();
		
		BuyerDao bdao = new BuyerDaoImpl();
		Buyer buyer = new Buyer(Bname, Bemail, Bpassword);
		register = bdao.registerBuyer(buyer);
		return register;
		
	}
	
	
	public static void searchByCategoryUsecase() throws BuyerException {
		Scanner sc = new Scanner(System.in);
		BuyerDao bdao = new BuyerDaoImpl();
		System.out.println("Select a Category from following");
		List<String> lsc = bdao.showCategory();
		for(String s:lsc) {
			System.out.println(s);
		}
		String category = sc.next();
		List<Item> listbyCategory = bdao.searchByCategory(category);
		if(listbyCategory.isEmpty()) {
			System.out.println("No Items Available with this Category");
		}else {
			listbyCategory.forEach(s -> {
	 			System.out.println("Item id is : "+ s.getItemId());
	 			System.out.println("Item Name is : "+ s.getIName());
	 			System.out.println("Item Price is : "+ s.getPrice());
	 			System.out.println("Item Quantity is : "+ s.getQuantity());
	 			System.out.println("Item Category is : "+ s.getCategory());
	 			System.out.println("Item SellerID is : "+ s.getSellerID());
	 			System.out.println("================================");
	 		 });
			
		}
		
	}
	
	
	
	public static void buyItem(int BuyerID) {
		Scanner sc = new Scanner(System.in);
		BuyerDao bdao = new BuyerDaoImpl();
		List<Item> list = bdao.showItem();
		list.forEach(S -> System.out.println(S));
	    System.out.println("Please Select ItemID to buy the Item");
		int ItemID = sc.nextInt();
		list.forEach(s -> {
			if(s.getItemId()== ItemID){
			    Item item = bdao.buyItem(ItemID);
			    bdao.ItemPurchase(item,BuyerID);
			    System.out.println("Item id is : "+ item.getItemId());
	 			System.out.println("Item Name is : "+ item.getIName());
	 			System.out.println("Item Price is : "+ item.getPrice());
	 			System.out.println("Item Quantity is : "+ item.getQuantity());
	 			System.out.println("Item Category is : "+ item.getCategory());
	 			System.out.println("Item SellerID is : "+ item.getSellerID());
	 			System.out.println("================================");
			}
		});
		}
	}


