package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewProfileServlet
 */
public class ViewProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext sc=getServletContext();
		Object oo=sc.getAttribute("userid");           //accessing value of userid from container and return type of getSAttribute method is Object class
		String email=oo.toString();                   //converting Object into string using toString() method
		
		HttpSession ss=request.getSession(true); //creating session to share information bydefault session will be valid for 30 minutes
		Object oo1=ss.getAttribute("userid");
		String email1=oo1.toString();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("user id using ServletContext is "+email);
		out.println("<br>user id using HttpSession is "+email1);
		out.println("</body></html>");
		
	}

}
