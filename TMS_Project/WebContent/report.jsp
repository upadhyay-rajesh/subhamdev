<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>TaskId</th>
		<th>TaskName</th>
		<th>Description</th>
		<th colspan="2" align="center">StartDate</th>
		<th></th>
		<th colspan="2" align="center">EndDate</th>
		<th></th>
		<th>Task Status</th>
	</tr>
	<c:forEach var="n" items="${tasklist}" varStatus="s">
		<tr>
			<td><c:out value="${n.taskid}" /></td>
			<td><c:out value="${n.taskname}" /></td>
			<td><c:out value="${n.description}" /></td>
			<td colspan="2" align="center"><c:out value="${n.sdate}" /></td>
			<td></td>
			<td colspan="2" align="center"><c:out value="${n.edate}" /></td>
			<td></td>
			<td><c:out value="${n.currentstatus}" /></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>