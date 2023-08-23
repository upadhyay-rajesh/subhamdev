<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Day to Day Task</title>
<script type="text/javascript">
function chkSearchType(str)
{
	if (str=="")
  	{
		document.getElementById("days").disabled=true;
		document.getElementById("submit").disabled=true;
  	} 
	else if(str=="completed")
	{
		document.getElementById("submit").disabled=false;
		document.getElementById("days").disabled=true;
	}
	else if(str=="delayrequest")
	{
		document.getElementById("days").disabled=false;
		document.getElementById("submit").disabled=false;
	}
}
</script>
</head>
<body>
<form method="post" action="modifyStatus.htm">
<table border="1">
	<% pageContext.setAttribute("tsd",new java.util.Date().getTime()); %>
	<tr>
		<th>TaskId</th>
		<th>TaskName</th>
		<th>Description</th>
		<th>StartDate</th>
		<th>EndDate</th>
		<th>Status</th>
		<th>Days Left</th>
		<td colspan="3" align="center"><b>Modify Task Status</b></td>
	</tr>

	<c:forEach var="n" items="${tasklist}" varStatus="s">
		<tr>
			<input type="hidden" name="taskid" value="${n.taskid}">
			<td><c:out value="${n.taskid}" /></td>
			<td><c:out value="${n.taskname}" /></td>
			<td><c:out value="${n.description}" /></td>
			<td><c:out value="${n.sdate}" /></td>
			<td><c:out value="${n.edate}" /></td>
			<td><c:out value="${n.currentstatus}" /></td>
			<c:set var="remainder"
				value="${(n.edate.time-tsd)/ (1000 * 60 * 60 * 24)}" />
			<c:choose>
				<c:when test="${remainder eq 0}">
					<fmt:formatNumber
						value="${(n.edate.time-tsd)/ (1000 * 60 * 60 * 24)}" type="number"
						pattern="0" var="daysleft" />
				</c:when>
				<c:otherwise>
					<fmt:formatNumber
						value="${(n.edate.time-tsd)/ (1000 * 60 * 60 * 24)+1}"
						type="number" pattern="0" var="daysleft" />
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${daysleft<4}">
					<td bgcolor="red"><c:out value="${daysleft}" /></td>
				</c:when>
				<c:otherwise>
					<td bgcolor="green"><c:out value="${daysleft}" /></td>
				</c:otherwise>
			</c:choose>


			<td><select name="statusReq"
				onchange="chkSearchType(this.value)">
				<option value="">Select</option>
				<option value="completed">Completed</option>
				<option value="delayrequest">Delay Request</option>
			</select></td>
			<td><select name="days" id="days" disabled>
				<option value="1">1 day</option>
				<option value="3">3 days</option>
				<option value="7">7 days</option>
				<option value="10">10 days</option>
			</select></td>
			<td><input type="submit" id="submit" disabled></td>
		</tr>
	</c:forEach>
</table>
</form>
<% if(request.getAttribute("message")!=null)
{
	out.print(request.getAttribute("message"));
}
%>
</body>
</html>