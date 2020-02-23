package com.ibm.wallet1.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome5")
public class fundTransfer extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection dbcon;
		PreparedStatement pstmt;
	//Database Connectivity
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmservletdata?serverTimezone=UTC","root","");
			System.out.println("Connected");
			
//Fund Transfer
			int fromacc = Integer.parseInt(request.getParameter("from accountID"));
			int toacc = Integer.parseInt(request.getParameter("to accountID"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
			String Qry = "SELECT Balance FROM accountdetails WHERE accountID = ?";
	         
	         
	         int updatedbalance1 = 0;
	         pstmt = dbcon.prepareStatement(Qry);
	         pstmt.setInt(1, fromacc);
	         ResultSet rs= pstmt.executeQuery();
				while(rs.next()) {
	           int currentbalance1 = rs.getInt("Balance");
	           //System.out.println("Current Balance : " + currentbalance1 );
	           updatedbalance1 = currentbalance1 - amount;
	           //System.out.println("Updated balance : " +updatedbalance1);
				}
	         
	        
	         String Qry1 = " UPDATE accountdetails SET accountdetails.Balance = ? "
	          		+ "WHERE account_details.accountID=?";   
	         pstmt=dbcon.prepareStatement(Qry1);
	         pstmt.setInt(1, updatedbalance1);
	         pstmt.setInt(2, fromacc);
	         
	         pstmt.executeUpdate();
	         
	         String Qryy = "SELECT Balance FROM accountdetails WHERE accountID = ?";
	         pstmt=dbcon.prepareStatement(Qryy);
	         int updatedbalance2=0;
	         pstmt = dbcon.prepareStatement(Qry);
	         pstmt.setInt(1, toacc);
	         ResultSet rs1= pstmt.executeQuery();
				while(rs1.next()) {
	        int currentbalance2 = rs1.getInt("Account_Balance");
	        //System.out.println("Current Balance : " + currentbalance2 );
	        updatedbalance2 = currentbalance2 + amount;
	        //System.out.println("Updated balance : " +updatedbalance2);
				}
			
				
				
				
				String Qry2 = "UPDATE accountdetails SET account_details.Balance = ?"
		          		+ " WHERE accountdetails.accountID=?";
				pstmt=dbcon.prepareStatement(Qry2);
	         pstmt.setInt(1, updatedbalance2);
	         pstmt.setInt(2, toacc);
	         pstmt.executeUpdate();
	         
	         String Qry3 = "INSERT INTO transactiondetails(id, Time, FromAccID, ToAccID) VALUES (NULL,current_timestamp(),?,?)";
	         
	         pstmt = dbcon.prepareStatement(Qry3);
	         pstmt.setInt(1, fromacc);
	         pstmt.setInt(2, toacc);
	         
	         pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Exception Occurred during fund transfer : " + e.getMessage());
		}
		
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception Occurred during fund transfer : " + e1.getMessage());
		}
	}

}