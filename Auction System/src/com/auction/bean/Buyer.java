package com.auction.bean;

public class Buyer {
	private int BuyerID;
	private String Bname;
	private String Bemail;    
	private String Bpassword;
	
	public Buyer(int buyerID, String bname, String bemail, String bpassword) {
		super();
		BuyerID = buyerID;
		Bname = bname;
		Bemail = bemail;
		Bpassword = bpassword;
	}
	
	public Buyer() {
		super();
	}
	
	public Buyer(String bname, String bemail, String bpassword) {
		super();
		Bname = bname;
		Bemail = bemail;
		Bpassword = bpassword;
	}

	public int getBuyerID() {
		return BuyerID;
	}

	public void setBuyerID(int buyerID) {
		BuyerID = buyerID;
	}

	public String getBname() {
		return Bname;
	}

	public void setBname(String bname) {
		Bname = bname;
	}

	public String getBemail() {
		return Bemail;
	}

	public void setBemail(String bemail) {
		Bemail = bemail;
	}

	public String getBpassword() {
		return Bpassword;
	}

	public void setBpassword(String bpassword) {
		Bpassword = bpassword;
	}

	@Override
	public String toString() {
		return "Buyer [BuyerID=" + BuyerID + ", Bname=" + Bname + ", Bemail=" + Bemail + ", Bpassword=" + Bpassword
				+ "]";
	}
	
	
	
}
