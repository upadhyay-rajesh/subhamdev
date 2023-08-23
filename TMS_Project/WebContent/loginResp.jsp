<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<% 
if(!(request.getAttribute("message").toString()=="null"))
{
%>

<%
session.setAttribute("emp",request.getAttribute("message")); %>
<jsp:forward page="empHome.jsp"></jsp:forward>
<%}
else
{
	%>

<jsp:forward page="home.jsp"></jsp:forward>
<h5><font color="red">Invalid Id or Password</font></h5>
<% 
}	
%>
</body>
</html>