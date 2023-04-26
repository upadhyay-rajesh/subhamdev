package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutProfileServlet
 */
public class LogoutProfileServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss=request.getSession(true);
		ss.invalidate(); //invalidate method will delete value from container immediately so we will not be able to access next page
		
	//	response.setContentType("text/html");
	//	PrintWriter out=response.getWriter();
		
		//out.println("<html><body>");
		System.out.println("your session has expired ");
		//out.println("</body></html>");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("login.html");
		
		
		
	}

}
