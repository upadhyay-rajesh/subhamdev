<%@page import="com.facebookweb.entity.FacebookUser"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
			String email=session.getAttribute("userid").toString();
%>
			<br>Welcome <%= email %>
			
			<br><a href=ViewProfileServlet>view profile</a> 
			<br><a href=EditProfileServlet>edit profile</a> 
			<br><a href=DeleteProfileServlet>delete profile</a> 
			<br><a href=SearchProfileServlet>search profile</a> 
			<br><a href=ViewAllProfileServlet>view all profile</a> 
			<br><a href=TimeLineProfileServlet>timeline profile</a> 
			<br><a href=LogoutProfileServlet>logout</a> 
			
			<%
				List<FacebookUser> ll=(List<FacebookUser>)request.getAttribute("userlist");
				for(FacebookUser f1:ll){ %>
					<form method=post action=AddFriendServlet>
						<label><%= f1.getName() %></label><br>
						<input type=hidden name="em" value=<%= f1.getEmail() %>>
						<input type=submit value="Add Friend">
					</form>
				<%}
			
			%>

</body>
</html>