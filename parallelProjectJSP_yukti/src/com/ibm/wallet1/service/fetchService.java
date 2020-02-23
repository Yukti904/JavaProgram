package com.ibm.wallet1.service;

import com.ibm.wallet1.dao.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detailsservice")
public class fetchService extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		fetchDetails det=new fetchDetails();
		det.doPost(request,response);
		
	}

}
