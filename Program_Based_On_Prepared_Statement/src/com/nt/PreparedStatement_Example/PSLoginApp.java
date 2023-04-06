package com.nt.PreparedStatement_Example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PSLoginApp {

	private static final String LOGIN_QUERY = "SELECT COUNT(*) FROM IRCTC_TAB WHERE UNAME=? AND PWD=?";

	public static void main(String[] args) {

		Scanner sc = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			// read inputs
			sc = new Scanner(System.in);

			String user = null;
			String pass = null;

			if (sc != null) {

				System.out.println("Enter Login UserName :: ");
				user = sc.nextLine();// Virat Kohli
				System.out.println("Enter Login Password :: ");
				pass = sc.nextLine();// gives Anuska Sharma
			} // if

			// Load JDBC driver class (optional)
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Establish the Connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");

			// create JDBC PraparedStatement object
			ps = con.prepareStatement(LOGIN_QUERY);

			// set values to the params of pre-compiled SQL query
			if (ps != null) {
				ps.setString(1, user);
				ps.setString(2, pass);

			}

			// send and execute the SQL query in Db s/w
			if (ps != null)
				rs = ps.executeQuery();

			// process the ResultSet object
			if (rs != null) {

				rs.next(); // moves the cursor to first Record from BFR
				int count = rs.getInt(1); // get first col value of that first record

				// process the result set
				if (count == 0)
					System.out.println("INVALID CREDENTIALS");
				else
					System.out.println("VALID CREDENTIALS");

			} // if

		} // try
		catch (SQLException se) {

			se.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			// close jdbc objs
			try {

				if (rs != null)
					rs.close();

			} catch (SQLException se) {

				se.printStackTrace();
			}
			try {

				if (ps != null)
					ps.close();

			} catch (SQLException se) {

				se.printStackTrace();
			}
			try {

				if (con != null)
					con.close();

			} catch (SQLException se) {

				se.printStackTrace();
			}
		} // finally

	}// main

}// class
