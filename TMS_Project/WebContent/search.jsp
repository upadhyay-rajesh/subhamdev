<%@page import="com.entity.*" isELIgnored="false"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Management System</title>

<script type="text/javascript">
function chkSearchType(str)
{
if (str=="")
  {
  document.getElementById("txtHint").innerHTML="";
  return;
  }  
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
    document.getElementById("txtHint").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","find.jsp?q1="+str,true);
xmlhttp.send();
}
function fun()
{
  var submitBtn = document.getElementById("r");
  submitBtn.disabled = false;
}
function showimage(str){
   var vid =str.id * (-1); 
   var trid = document.getElementById(vid);
   trid.style.display= "inline";
}
function hideimage(str){
	var vid =str.id * (-1); 
	   var trid = document.getElementById(vid);
	   trid.style.display= "none";
}
</script>
</head>

<body>
<form id="searchfrm" action="searchlist.htm" target="_self">
<table>
	<tr>
		<td><select id="searchtype" name="searchtype"
			onchange="chkSearchType(this.value)">
			<option value="">Select</option>
			<option value="emailid">Search By EmailID</option>
			<option value="fname">Search By Firstname</option>
			<option value="lname">Search By Lastname</option>
		</select></td>
		<td><input type="submit" value="SEARCH" id="r" disabled></td>
	</tr>
</table>
<br />
<div id="txtHint"></div>
</form>
<c:choose>
	<c:when test="${empty type}"></c:when>
	<c:when test="${type=='notfound'}">
		<table border="1">
			<tr>
				<th>EmpId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>EmailID</th>
			</tr>
			<tr align="center">
				<td colspan="4"><b>No Record Found</b></td>
			</tr>
		</table>
	</c:when>
	<c:otherwise>
		<table border="1">
			<tr>
				<th>EmpId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>EmailID</th>
			</tr>
			<c:forEach var="n" items="${message}" varStatus="s">
				<tr id="${n.empid * (-1)}" onmouseover="showimage(this)"
					onmouseout="hideimage(this)">
					<td><c:out value="${n.empid}" /></td>
					<td><c:out value="${n.fname}" /></td>
					<td><c:out value="${n.lname}" /></td>
					<td><c:out value="${n.emailid}" /></td>
					<td><table>
						<tr id="${n.empid}" style="display: none">
						<td colspan="2" align="center"><img src="${n.imgpath}"
						height="50" width="70"></img></td>
						<td colspan="2"><b>Contact No.: </b><c:out value="${n.phno}" /><br>
							<b>Address: </b><c:out value="${n.address}" /></td>
						</tr>
					</table>
				</td>
				</tr>
				
			</c:forEach>
		</table>
	</c:otherwise>
</c:choose>

</body>
</html>