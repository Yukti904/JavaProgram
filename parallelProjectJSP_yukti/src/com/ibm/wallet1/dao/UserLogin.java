package com.ibm.wallet1.dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection dbCon;
		PreparedStatement pstmt;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3307/ibmservletdata?serverTimezone=UTC", "root",
					"");
			System.out.println("Connected to the database");
			String selQuery = "SELECT * FROM bankdatajsp WHERE Name = ?";
			pstmt = dbCon.prepareStatement(selQuery);
			pstmt.setString(1, request.getParameter("username"));

			ResultSet rs = pstmt.executeQuery();
			String password = null;
			while (rs.next()) {
				password = rs.getString("Password");

			}
			String password1 = request.getParameter("password");

			if ((password1).contentEquals(password)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("username", request.getParameter("username"));
				session.setAttribute("password", request.getParameter("password"));
				RequestDispatcher rd = request.getRequestDispatcher("welcome.jsp");
				rd.include(request, response);

			}

		} catch (SQLException e) {
			System.out.println("Exception while connecting to database " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Exception class not found " + e.getMessage());
		}

	}

}
