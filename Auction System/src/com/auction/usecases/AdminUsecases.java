package com.auction.usecases;

import java.util.Scanner;

import com.auction.Dao.AdminDao;
import com.auction.Dao.AdminDaoImpl;
import com.auction.bean.Admin;
import com.auction.exceptions.AdminException;



public class AdminUsecases {
	
	public static boolean AdminloginUsecase() {
		boolean login = false;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Admin Username");
		String username = sc.next();
		
		System.out.println("Enter Admin Password");
		String password = sc.next();
		
		AdminDao Adao = new AdminDaoImpl();
		try {
			Admin admin = Adao.loginAdmin(username, password);
			System.out.println("Welcome Admin " + admin.getName());
			login = true;
			
		} catch (AdminException e) {
			System.out.println(e.getMessage());
		}
		return login;
	}

}
