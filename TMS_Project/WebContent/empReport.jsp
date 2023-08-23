<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report</title>
<script language="JavaScript" src="calendar_db.js"></script>
<link rel="stylesheet" href="calendar.css">
</head>
<body>

<form name="report" method="post" action="generateReport.htm">
<table width="100%">
	<tr>
		<td>From Date:</td>
		<td><input type="text" name="sdate" /><script
			language="JavaScript">
	new tcal ({
		// form name
		'formname': 'report',
		// input name
		'controlname': 'sdate'
	});

	</script></td>
		<td>To Date:</td>
		<td><input type="text" name="edate" /><script
			language="JavaScript">
	new tcal ({
		// form name
		'formname': 'report',
		// input name
		'controlname': 'edate'
	});

	</script></td>
		<td><input type="submit" value="submit"></td>
	</tr>
</table>
</form>
<c:choose>
	<c:when test="${empty message}"></c:when>
	<c:otherwise>
		<jsp:include page="report.jsp"></jsp:include>
	</c:otherwise>
</c:choose>
<div id="reportSection"></div>
</body>
</html>