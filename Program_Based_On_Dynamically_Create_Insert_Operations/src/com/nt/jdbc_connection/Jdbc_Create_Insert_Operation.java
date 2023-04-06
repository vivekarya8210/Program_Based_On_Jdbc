package com.nt.jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.nt.beans.StudentInfo;

public class Jdbc_Create_Insert_Operation{
	
	public static void main(String[] args) {
		StudentInfo si;
		Scanner sc;
		Connection con;
		PreparedStatement pmt;
		ResultSet rs;
	  try {
			sc=new Scanner(System.in);
			si=new StudentInfo();
			
			System.out.println("Enter Student Name ::");
			si.setSname(sc.nextLine());
			System.out.println("Enter Student Id :: ");
			si.setSid(sc.nextInt());
			
			System.out.println("Enter Student Address ::");
			si.setSadd(sc.next());
			
			
			 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:xe","xe","XEE");
			 String s1=si.getSname();	
			 int i2=si.getSid();
			 String s3=si.getSadd();			
			
			 
			 if(si!=null) {
				pmt=con.prepareStatement("INSERT INTO STUDENTINFO VALUES( ?,?,?) ");
				
				pmt.setString(1,s1);
				pmt.setInt(2,i2);
				pmt.setString(3,s3);
				 rs=pmt.executeQuery();
				
				System.out.println("One record inserted successfully");
				
			}
			else {
			  System.out.println("Enter Student Data");
			}
			}//try
		  catch(SQLException se) {
			  se.printStackTrace();
		  }
			    
		catch (Exception e) {

			e.printStackTrace();
			}
	}


}
