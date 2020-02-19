package com.ibm.training;

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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	PreparedStatement pstmt;
	Connection dbCon;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if (request.getSession(false) == null) {
			out.println("<br> Your session has ended <br><br>");
			RequestDispatcher dispatch = request.getRequestDispatcher("index.html");
			dispatch.include(request, response);
		} else {
			int n = 0;
			RequestDispatcher dispatch = null;
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			out.println("<br> user name is: " + userName);

			String Query = "SELECT Name FROM userdata";
			String PassWord = "SELECT Password FROM userdata WHERE Name=?";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibmservletdata?serverTimezone=UTC", "root",
						"");
				pstmt = dbCon.prepareStatement(Query);
				ResultSet rs = pstmt.executeQuery();
				if (rs.next()) {
					if (userName.trim().equals(rs.getString("userName")))
						n = n + 1;
				}
				pstmt = dbCon.prepareStatement(PassWord);
				pstmt.setString(1, userName);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					if (passWord.trim().equals(rs.getString("passWord")))
						n = n + 1;
				}
				request.getSession().getAttribute("userName");
				if (n == 2) {
					dispatch = request.getRequestDispatcher("logout.html");
					dispatch.include(request, response);
				} else {
					out.println("username or password not correct <br>");
					dispatch = request.getRequestDispatcher("index.html");
					dispatch.include(request, response);
				}
			} catch (SQLException e) {
				System.out.println("Errorrrr" + e.getMessage());
			} catch (ClassNotFoundException e) {
				System.out.println("Class errorr");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}