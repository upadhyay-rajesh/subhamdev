<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approval Task</title>
<script type="text/javascript">
function perform(str,con)
{
  if (str=="")
  {
  return;
  }
   if(confirm("Are u sure?"))
   {
        var vid=con.name *(-1);
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
       			   
         			document.getElementById(vid).innerHTML=xmlhttp.responseText;
         			 con.disabled=true;
        		 }
      	    }
     	xmlhttp.open("GET","approveTask.htm?adminstatus="+str+"&approvaltaskid="+vid,true);
     	xmlhttp.send();
     	
   }
  } 
  </script>
</head>
<body>
<table border="1" cellspacing="0">
	<caption>Approve Task</caption>
	<tr>
		<td>
		<table border="1">
			<tr>
				<th>TaskId</th>
				<th>TaskName</th>
				<th>EmpId</th>
				<th colspan="2" align="center">StartDate</th>
				<th></th>
				<th colspan="2" align="center">EndDate</th>
				<th></th>
			</tr>
			<c:forEach var="n" items="${tasklist}" varStatus="s">
				<tr>
					<td><c:out value="${n.taskid}" /></td>
					<td><c:out value="${n.taskname}" /></td>
					<td><c:out value="${n.empid}" /></td>
					<td colspan="2" align="center"><c:out value="${n.sdate}" /></td>
					<td></td>
					<td colspan="2" align="center"><c:out value="${n.edate}" /></td>
					<td></td>
				</tr>
			</c:forEach>
		</table>
		</td>
		<td>
		<table border="1">
			<tr>
				<th colspan="2" align="center">RequestedDays</th>
				<th></th>
				<th colspan="2" align="center">Action</th>
				<th></th>
			</tr>
			<c:forEach var="n" items="${aptasklist}" varStatus="s">
				<tr>
					<td colspan="2" align="center"><c:out value="${n.days}" /></td>
					<td></td>
					<td><select name="${n.approvaltaskid *(-1)}"
						onchange="perform(this.value,this)">
						<option value="">Select</option>
						<option value="approve">Approve</option>
						<option value="reject">Reject</option>
					</select></td>
					<td>
					<div id="${n.approvaltaskid}"></div>
					</td>
				</tr>
			</c:forEach>
		</table>
		</td>
	</tr>
</table>
</body>
</html>