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

/**
 * Servlet implementation class EditProfileServlet1
 */
public class EditProfileServlet1 extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
		Object oo1=ss.getAttribute("userid");
		String email1=oo1.toString();
		
		String name=request.getParameter("nm");
		
		String password=request.getParameter("pw");
		String address=request.getParameter("ad");
		
		FacebookUser fu=new FacebookUser();
		fu.setName(name);
		fu.setPassword(password);
		fu.setEmail(email1);
		fu.setAddress(address);
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		int i=fs.editUserService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
			out.println("<br>Hello "+name);
			out.println("<br>Your Profile Edited successful ");
					
			}
			else {
				out.println("oops something is wrong");
			}
		out.println("</body></html>");
	}

}
