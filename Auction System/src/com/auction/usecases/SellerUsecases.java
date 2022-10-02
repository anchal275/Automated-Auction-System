package com.auction.usecases;

import java.util.List;
import java.util.Scanner;

import com.auction.Dao.SellerDao;
import com.auction.Dao.SellerDaoImpl;
import com.auction.bean.Item;
import com.auction.bean.Seller;
import com.auction.exceptions.SellerException;

public class SellerUsecases {
	
		public static Seller SellerloginUsecase() {
			Seller seller = null;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Seller Username");
			String username = sc.next();
			
			System.out.println("Enter Seller Password");
			String password = sc.next();
			
			SellerDao Sdao = new SellerDaoImpl();
			try {
				seller = Sdao.loginSeller(username, password);
				System.out.println("Welcome Seller " + seller.getSname());
			} catch (SellerException e) {
				System.out.println(e.getMessage());
			}
			return seller;
		}
	
		
		public static String SellerRegisterUsecase() {
			String register = null;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Seller Name");
			String Sname = sc.next();
			
			System.out.println("Enter Seller Email");
			String Semail = sc.next();
			
			System.out.println("Enter Seller Password");
			String Spassword = sc.next();
			
			SellerDao sdao = new SellerDaoImpl();
	        Seller seller = new Seller(Sname, Semail, Spassword);
	        register = sdao.registerSeller(seller);
			return register;
		}
		
		
		public static String ItemAddedUsecase(int SellerID) {
		         Scanner sc = new Scanner(System.in);
		         String message = null;
		     
		         System.out.println("Enter Item Name");
		         String IName = sc.next();
		         
		         System.out.println("Enter Item Price");
		         int Price = sc.nextInt();
		         
		         System.out.println("Enter Item Quantity");
		         int Quantity = sc.nextInt();
		         
		         System.out.println("Enter Item Category");
		         String Category = sc.next();
		         
		         SellerDao sdao = new SellerDaoImpl();
		         Item item = new Item(IName, Price, Quantity, Category, SellerID);
		         message = sdao.AddItemToSell(item);
		         return  message;

		}
		
		public static String ItemRemovedUsecase() {
			 Scanner sc = new Scanner(System.in);
	         String message = null;
	         
	         System.out.println("Enter Item Id To Remove");
	         int ItemId = sc.nextInt();
	         
	         SellerDao sdao = new SellerDaoImpl();
	         message = sdao.removeItem(ItemId);
	         return  message;
		}
		
		public static void ViewItemBySeller(int SellerID) {
		     SellerDao sdao = new SellerDaoImpl();
			 List<Item> itemlist = sdao.ShowItemOfSeller(SellerID);
     		 itemlist.forEach(s -> {
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
     
		
