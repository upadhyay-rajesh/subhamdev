<%@page import="java.time.LocalTime"%>

<%
		Integer rr=(Integer)request.getAttribute("message");

	String name=request.getAttribute("nm").toString();

		
		if (rr > 0) {  %>
				<br>Hello <%= name %>
				<br>Your Registration is successful 
				<br><a href=login.html>Continue...</a> 

		<%	} else {  %>
				oops something is wrong
		<%	}%>