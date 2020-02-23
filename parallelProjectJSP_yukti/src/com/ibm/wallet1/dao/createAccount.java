package com.ibm.wallet1.dao;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/welcome")
public class createAccount extends HttpServlet {
	
	
	
 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out1 = response.getWriter();
		Connection dbcon;
		PreparedStatement pstmt;
		
	try {
			Class.forName("com.mysql.jdbc.Driver");
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost:3307/Parallel_Project?serverTimezone=UTC","root","");
			System.out.println("Connected");
			
//Insert into the database:	
			String phonenumber = request.getParameter("phonenumber");
			
			String inQry="INSERT INTO 'accountdetails`(`Name`, `PhoneNumber`, `Account_type`, `balance`) VALUES (?,?,?,?)";
			pstmt=dbcon.prepareStatement(inQry);
			pstmt.setString(1, request.getParameter("customer name"));
			pstmt.setString(2, phonenumber);
			pstmt.setString(3,request.getParameter("type"));
			pstmt.setString(4, request.getParameter("balance"));
			pstmt.execute();
			
		out1.println("Account Created Successfully..." + request.getParameter("customer name"));
		RequestDispatcher rd = request.getRequestDispatcher("AccountID.jsp");
		rd.include(request, response);
		
		}
		
		catch(SQLException e)
		{
			System.out.println("Exception Occurred during connection : " +e.getMessage());
		}
		catch(ClassNotFoundException e1)
		{
			System.out.println("Exception Occurred during connection class : " +e1.getMessage());
		}
	

	
}
}

