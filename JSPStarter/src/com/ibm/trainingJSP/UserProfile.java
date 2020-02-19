package com.ibm.trainingJSP;

import com.ibm.trainingJSP.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
		PrintWriter out = response.getWriter();
		String uname = request.getParameter("uname");
		String upass = request.getParameter("upass");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3307/ibmservletdata?serverTimezone=UTC", "root", "");

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select Name,Password from userdata where Name='" + uname + "' and Password='" + upass + "'");

			if (rs.next()) {
				response.sendRedirect("http://localhost:8090/loginDemo/WelcomeUser.jsp?name=" + rs.getString("uname"));
				HttpSession session = request.getSession();
				session.setAttribute("uname", uname);

			} else {
				out.println("Wrong id and password");
			}

		} catch (ClassNotFoundException e) {

			e.getMessage();
		} catch (SQLException e) {
			
			e.getMessage();
		}

	}
}