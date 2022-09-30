package com.auction.utility;

import java.sql.Connection;

public class Demo {

	public static void main(String[] args) {
		Connection conn = DBUtil.ProvideConnection();
		System.out.println(conn);
	}

}
