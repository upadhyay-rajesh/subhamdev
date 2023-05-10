<%@page import="java.time.LocalTime"%>

<%
		LocalTime lt=(LocalTime)request.getAttribute("message");
%>
		Current time is  <input type=text value=<%= lt %> id=c2 >
			
			