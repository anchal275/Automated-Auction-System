package com.auction.bean;

public class Seller {
	private int SellerID;
	private String Sname;
	private String Semail;
	private String Spassword;
	
	public Seller(int sellerID, String sname, String semail, String spassword) {
		super();
		SellerID = sellerID;
		Sname = sname;
		Semail = semail;
		Spassword = spassword;
	}

	public Seller() {
		super();
	}

	public int getSellerID() {
		return SellerID;
	}

	public void setSellerID(int sellerID) {
		SellerID = sellerID;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getSemail() {
		return Semail;
	}

	public void setSemail(String semail) {
		Semail = semail;
	}

	public String getSpassword() {
		return Spassword;
	}

	public void setSpassword(String spassword) {
		Spassword = spassword;
	}

	@Override
	public String toString() {
		return "Seller [SellerID=" + SellerID + ", Sname=" + Sname + ", Semail=" + Semail + ", Spassword=" + Spassword
				+ "]";
	}

	public Seller(String sname, String semail, String spassword) {
		super();
		Sname = sname;
		Semail = semail;
		Spassword = spassword;
	}

	
	
	
	
}
