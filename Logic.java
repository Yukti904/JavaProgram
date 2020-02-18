package com.ibm.servletTraining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logic
 */
@WebServlet("/logic")
public class Logic extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
//		Set the content type
		response.setContentType("text/html");
		String name = request.getParameter("name");
		System.out.println("Nmae of the student : " + name);
		String gender = request.getParameter("Gender");
		if(gender.equals("male")) {
			System.out.println("Gender is : " + gender);
		}
		if(gender.equals("female")) {
			System.out.println("Gender is : " + gender);
		}
		String dept = request.getParameter("Department");
	    String subject[] = request.getParameterValues("subjects");
	    for(String value : subject) {
	      System.out.println("The subjects studied are : " + value);	
	    }
		
	    PrintWriter out = response.getWriter();
	    out.println("Nmae of the student is : " + name);
	    out.println("Gender : " +gender);
	    out.println("Department : " + dept);
	    
//		Get the value from form
	
	
		//Validate the user
		/*
		 * if(user.trim().equals("IBM")) { response.getWriter().print("Welcome " + user)
		 * ; } else {
		 */
			response.getWriter().print("Invalid username...") ;
			
//			response.sendRedirect("index.html");
			
//			response.sendRedirect("invalid");
			
			
//			Use a RequestDispatcher to forward the same request, response
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			
			//Dispatch the request further
//			dispatcher.forward(request, response);
			dispatcher.include(request, response);
		}
		/*
		 * String gender = request.getParameter("Gender");
		 * if(gender.trim().contentEquals("Male"))
		 */

		
     	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().println("Post requests now supported...");
		
		doGet(request, response);
	}

}
