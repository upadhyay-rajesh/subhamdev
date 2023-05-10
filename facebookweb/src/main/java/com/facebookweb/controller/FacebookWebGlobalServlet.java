package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.Country;
import com.facebookweb.entity.FacebookUser;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;

public class FacebookWebGlobalServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actype = request.getParameter("actiontype");

		FacebookServiceInterface fs = FacebookServiceFactory.createObject();

		if (actype.equalsIgnoreCase("checkEmail")) {
			String email = request.getParameter("emailvalue");
			FacebookUser fu = new FacebookUser();
			fu.setEmail(email);
			int i = fs.checkEmailService(fu);
			String str="";
			
			if (i > 0) {
				str="<font color=red>Email already have taken choose another email id</font>";
			} else {
				str="<font color=green>Valid Email</font>";
			}
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/checkemail.jsp");
			request.setAttribute("message", str);
			rd.forward(request, response);
		}

		if (actype.equalsIgnoreCase("loadCountry")) {
			List<Country> i = fs.loadCountryService();
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/loadcountry.jsp");
			request.setAttribute("message", i);
			rd.forward(request, response);
			
		}
		if (actype.equalsIgnoreCase("loadClock")) {
			LocalTime lt = LocalTime.now();
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/loadclock.jsp");
			request.setAttribute("message", lt);
			rd.forward(request, response);
			
		}

		if (actype.equalsIgnoreCase("loadCaptcha")) {
			int rr = (int) ((Math.random()) * 10000);
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/loadcaptcha.jsp");
			request.setAttribute("message", rr);
			rd.forward(request, response);
			

		}
		if (actype.equalsIgnoreCase("registeration")) {
			String name = request.getParameter("first_name");
			String lastname = request.getParameter("last_name");
			String email = request.getParameter("email");
			String password = request.getParameter("pwd");
			String address = request.getParameter("address");

			FacebookUser fu = new FacebookUser();
			fu.setName(lastname);
			fu.setPassword(password);
			fu.setEmail(email);
			fu.setAddress(address);
			int i = fs.registerUserService(fu);
			
			RequestDispatcher rd=getServletContext().getRequestDispatcher("/registerresult.jsp");
			request.setAttribute("nm", name);
			request.setAttribute("message", i);
			rd.forward(request, response);
			
		}
		if (actype.equalsIgnoreCase("login")) {
			String email = request.getParameter("email");
			String password = request.getParameter("pwd");

			FacebookUser fu = new FacebookUser();

			fu.setPassword(password);
			fu.setEmail(email);

			int i = fs.loginUserService(fu);
			if (i > 0) {

				HttpSession ss = request.getSession(true); // creating session to share information bydefault session
				ss.setAttribute("userid", email);

				List<FacebookUser> ll = fs.viewAllUserService();

				RequestDispatcher rd = getServletContext().getRequestDispatcher("/userhomepage.jsp");
				request.setAttribute("userlist", ll);
				rd.forward(request, response);

			} else {
				//out.println("invalid id and password ");
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.html");
				rd.include(request, response);
			}
		}
		if (actype.equalsIgnoreCase("viewprofile")) {

		}
		if (actype.equalsIgnoreCase("editprofile")) {

		}
		if (actype.equalsIgnoreCase("deleteprofile")) {

		}
		if (actype.equalsIgnoreCase("searchprofile")) {

		}
		if (actype.equalsIgnoreCase("viewallprofile")) {

		}
		if (actype.equalsIgnoreCase("timeline")) {

		}
		if (actype.equalsIgnoreCase("logoutprofile")) {

		}
		
	}

}
