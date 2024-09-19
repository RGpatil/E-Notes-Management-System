package com.Db;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	private static Connection conn;

	public static Connection getConn() {

		if (conn == null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enotes", "root", "Rushi@99");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	/*
	 * public static void main(String args[]) { Connection conn=DBConnect.getConn();
	 * System.out.print(conn);
	 * 
	 * }
	 */
}
