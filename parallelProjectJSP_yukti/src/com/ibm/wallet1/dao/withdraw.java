package com.ibm.wallet1.dao;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class AccountFacilities2
 */
@WebServlet("/welcome2")
public class withdraw extends HttpServlet {
	
   
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		Connection dbcon;
		PreparedStatement pstmt;
	//Database Connectivity
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmservletdata?serverTimezone=UTC","root","");
			System.out.println("Connected");
			
	//Deposit and update the balance and update in transaction table:
			
			int accid = Integer.parseInt(request.getParameter("accid"));
			int amount = Integer.parseInt(request.getParameter("amount"));
			
		
		    String selQry = "SELECT Balance FROM accountdetails WHERE accountID=?";
		    pstmt = dbcon.prepareStatement(selQry);
		    pstmt.setInt(1, accid);
		    int updatedbalance=0;
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
	          int currentbalance = rs.getInt("Balance");
	          //System.out.println("Current Balance : " + currentbalance );
	          updatedbalance = currentbalance - amount;
	          //System.out.println("Updated balance : " +updatedbalance);
			}
			
			String upQry = "UPDATE accountdetails SET Balance = ? WHERE accountID = ?";
			pstmt=dbcon.prepareStatement(upQry);
			pstmt.setInt(1, updatedbalance);
			pstmt.setInt(2, accid);
	        pstmt.executeUpdate();	
	        
	        String inQry ="INSERT INTO transdetails(id, Time, FromAccID`, ToAccID`) VALUES (NULL,current_timestamp(),'0',?)";
	        pstmt=dbcon.prepareStatement(inQry);
	        pstmt.setInt(1, accid);
	        pstmt.executeUpdate();
	        
	        out.println("Amount Withdrawn Successfully...Account Balance = " +updatedbalance);
			
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception occurred while connecting to DB : " + e.getMessage());
		} 
		catch (ClassNotFoundException e) {
			
			System.out.println("Exception occurred due to class not found : " + e.getMessage());
		}
	}

}
