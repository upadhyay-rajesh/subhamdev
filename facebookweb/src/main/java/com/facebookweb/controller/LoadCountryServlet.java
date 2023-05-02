package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.Country;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;

/**
 * Servlet implementation class LoadCountryServlet
 */
public class LoadCountryServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		List<Country> i=fs.loadCountryService();
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		out.println("<select>");
			for(Country cc:i) {
				out.println("<option>"+cc.getCountryName()+"</option>");
			
			}
			
		out.println("</select>");
		out.println("</body></html>");
	}

}
