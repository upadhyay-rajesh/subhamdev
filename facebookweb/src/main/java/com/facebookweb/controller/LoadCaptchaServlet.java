package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.Country;

public class LoadCaptchaServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int rr=(int)((Math.random())*10000);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
			out.println("Captcha Value <input type=text value="+rr+" id=c disabled>");
			out.println("<button type=button onClick=loadCaptcha()>Refresh</button>");
			out.println("<br>Enter The Above Captcha Value <input type=text id=cc1>");
			out.println("<button type=button onClick=validateCaptcha()>Validate</button>");
			
		out.println("</body></html>");
	}

}
