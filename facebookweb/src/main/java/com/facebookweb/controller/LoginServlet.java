package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
				
		FacebookUser fu=new FacebookUser();
	
		fu.setPassword(password);
		fu.setEmail(email);
		
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		int i=fs.loginUserService(fu);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			if(i>0) {
				
				ServletContext sc=getServletContext(); //calling servlet container
				sc.setAttribute("userid",email);       //sharing value of email with servlet container
				
				HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
				ss.setAttribute("userid",email);
				
				ss.setMaxInactiveInterval(5); //setting session for 5 minutes


			out.println("<br>Welcome "+email);
			out.println("<br><a href=ViewProfileServlet>view profile</a> ");
			out.println("<br><a href=EditProfileServlet>edit profile</a> ");
			out.println("<br><a href=DeleteProfileServlet>delete profile</a> ");
			out.println("<br><a href=SearchProfileServlet>search profile</a> ");
			out.println("<br><a href=ViewAllProfileServlet>view all profile</a> ");
			out.println("<br><a href=TimeLineProfileServlet>timeline profile</a> ");
			out.println("<br><a href=LogoutProfileServlet>logout</a> ");
			
			}
			else {
				out.println("invalid id and password <a href=login.html>Try Again</a>");
			}
		out.println("</body></html>");
	}

}
