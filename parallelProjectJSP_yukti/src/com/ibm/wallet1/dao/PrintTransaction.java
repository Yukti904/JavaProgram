package com.ibm.wallet1.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/welcome6")
public class PrintTransaction extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	int accID = Integer.parseInt(request.getParameter("accountID"));
		Connection dbcon;
		PreparedStatement pstmt;
	//Database Connectivity
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmservletdata?serverTimezone=UTC","root","");
			System.out.println("Connected");
 // Print Transaction Details
			Statement stmt = dbcon.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `transdetails`");
			while(rs.next())
			{
				if((rs.getInt("FromAccID")==(accID)||rs.getInt("ToAccID")==(accID)))
				{
				int transId = rs.getInt(1);
				String time = rs.getString(2);
				int fromacc = rs.getInt(3);
				int toacc = rs.getInt(4);
				System.out.println("Transaction ID : " + transId + "Transaction time : "+ time + "Debit Account :  "  
						+ fromacc + "Credit Account : " + toacc);
				}
				
			
			}
	}
		catch(SQLException e) {
			System.out.println("Exception occurred during displaying the table : " + e.getMessage());
		}
		
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception occurred during displaying the table : " + e1.getMessage());
		}

}
}
