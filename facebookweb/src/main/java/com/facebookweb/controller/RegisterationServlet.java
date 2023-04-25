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


public class RegisterationServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("first_name");
		String lastname=request.getParameter("last_name");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		String address=request.getParameter("address");
		
		FacebookUser fu=new FacebookUser();
		fu.setName(lastname);
		fu.setPassword(password);
		fu.setEmail(email);
		fu.setAddress(address);
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		int i=fs.registerUserService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
			out.println("<br>Hello "+name);
			out.println("<br>Your Registration is successful ");
			out.println("<br><a href=login.html>Continue...</a> ");
			
			}
			else {
				out.println("oops something is wrong");
			}
		out.println("</body></html>");
	}

}
