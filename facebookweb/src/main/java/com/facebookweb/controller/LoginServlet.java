package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("pwd");
		
		
		ServletConfig sf=getServletConfig();
		Object oo=sf.getInitParameter("myvariable");
		
		ServletContext sf1=getServletContext();
		Object oo1=sf1.getInitParameter("myvariableoncontainer");
				
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
				
				Cookie c=new Cookie("mycookie", "hello");
				response.addCookie(c);
				
				//ss.setMaxInactiveInterval(5); //setting session for 5 minutes
				
				List<FacebookUser> ll=fs.viewAllUserService();
				
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/userhomepage.jsp");
				request.setAttribute("userlist", ll);
				rd.forward(request, response);


			
			
			}
			else {
				out.println("invalid id and password ");
				RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
		out.println("</body></html>");
	}

}


















