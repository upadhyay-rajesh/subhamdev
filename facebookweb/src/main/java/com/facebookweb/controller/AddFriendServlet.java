package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookweb.entity.FacebookUser;
import com.facebookweb.entity.FriendList;
import com.facebookweb.service.FacebookServiceFactory;
import com.facebookweb.service.FacebookServiceInterface;


public class AddFriendServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String receiverfriend=request.getParameter("em");
		HttpSession hs=request.getSession(true);
		String senderfriend=hs.getAttribute("userid").toString();
		
		FacebookUser f=new FacebookUser();
		f.setEmail(senderfriend);
		
		
		FriendList fl=new FriendList();
		fl.setReceiverfriend(receiverfriend);
		fl.setStatus("inactive");
		fl.setFl(f);
		
		FacebookServiceInterface fs=FacebookServiceFactory.createObject();
		String i=fs.friendRequestService(fl);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body><center>");
		if(i!=null) {
		out.println("<br>  Friend Request sent");
		}
		
		out.println("</center></body></html>");
	}

}
