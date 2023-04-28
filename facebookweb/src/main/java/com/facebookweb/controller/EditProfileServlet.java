package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;


public class EditProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
		Object oo1=ss.getAttribute("userid");
		String email1=oo1.toString();
		
		FacebookUser fu=new FacebookUser();
		fu.setEmail(email1);
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		FacebookUser i=fs.viewUserService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		out.println(" <p>Edit Page</p>");
		out.println("<br> <form method=post action=EditProfileServlet1");
		out.println("<br> Name : <input type=text name=nm value="+i.getName()+">");
		out.println("<br> Password : <input type=text name=pw value="+i.getPassword()+">");
		out.println("<br> Email : <input type=text name=em value="+i.getEmail()+" disabled>");
		out.println("<br> Address : <input type=text name=ad value="+i.getAddress()+">");
		out.println("<br>  <input type=submit  value=Update>");
		
		out.println("<br></form> ");
		out.println("</center></body></html>");
	}

}

















