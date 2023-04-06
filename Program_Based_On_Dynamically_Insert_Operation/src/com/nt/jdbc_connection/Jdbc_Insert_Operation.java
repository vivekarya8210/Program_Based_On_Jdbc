package com.nt.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

public class Jdbc_Insert_Operation{
	
	public static void main(String[] args) {
		Scanner sc;
		/// code for loading driver
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver ");
			sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe", "xe", "XEE");

			PreparedStatement pmt = con.prepareStatement("INSERT INTO BOOK VALUES(?,?,?)");

			System.out.println("Enter Book Name");
			pmt.setString(1, sc.nextLine());
			System.out.println("Enter Book's Auther Name");
			pmt.setString(2, sc.nextLine());
			System.out.print("Enter Book Price");
			pmt.setInt(3, sc.nextInt());

			System.out.println("Record inserted successfully");
			
			
		} catch (Exception e) {

			System.err.println(e);

		}

	}

}
