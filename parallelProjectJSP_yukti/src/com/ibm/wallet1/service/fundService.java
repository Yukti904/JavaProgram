package com.ibm.wallet1.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.ibm.wallet1.dao.*;

@WebServlet("/transferservice")
public class fundService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		fundService fun = new fundService();
		fun.doPost(request,response);
		
	}

}
