package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;

public class CheckEmailServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("emailvalue");
		
		//System.out.println(email);
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email);
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		int i=fs.checkEmailService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				out.println("<font color=red>Email already have taken choose another email id</font>");
			
						
			}
			else {
				out.println("<font color=green>Valid Email</font>");
			}
		out.println("</body></html>");
		
	}

}
