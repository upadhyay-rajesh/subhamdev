<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Task</title>
<script type="text/javascript">
function getvalues()
{
  
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("txtHint").innerHTML="hello";
    }
  }
xmlhttp.open("GET","getTasktoAssign.htm",true);
xmlhttp.send();
}
function fun()
{
  var submitBtn = document.getElementById("r");
  submitBtn.disabled = false;
}
</script>
</head>
<body>
<form action="allocatetask.htm" method="post">

<table border="1" rules="none" width="600" height="200">
	<tr>
		<td>Employee EmailId:</td>
		<td><select name="empid">
			<c:forEach var="n" items="${emplist}" varStatus="s">

				<option value="${n.empid}"><c:out value="${n.emailid}" /></option>

			</c:forEach>
		</select></td>

		<td>Task Name:</td>
		<td><select name="taskid">
			<c:forEach var="n" items="${tasklist}" varStatus="s">

				<option value="${n.taskid}"><c:out value="${n.taskname}" /></option>

			</c:forEach>
		</select></td>
	</tr>
	<tr>
		<td colspan="4" align="center"><input type=submit id="r"
			value="assign Task"></td>
	</tr>
</table>
</form>
<% if(request.getAttribute("message")!=null)
{
	out.print(request.getAttribute("message"));
}
%>
<div id="txtHint"></div>
</body>
</html>