<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Profile</title>

<script type="text/javascript">
function ChngPwd()
{
var p=document.getElementById("Pwd");
  if(p.style.display=='none')
  {
  p.style.display="inline";
 
  }
  else
	  p.style.display="none";
	  
}  

function ChngAddr()
{
	var p=document.getElementById("Address");
	  if(p.style.display=='none')
	  {
	  p.style.display="inline";
	
	  }
	  else
		  p.style.display="none";
		  
	 
}

function ChngPic()
{
  var p=document.getElementById("Pic");
  if(p.style.display=='none')
  {
  p.style.display="inline";
  document.getElementById("img1").style.display="inline";
  }
  else
  {
	  p.style.display="none";
	  document.getElementById("img1").style.display="none";
	  document.getElementById("nPic").value="${sessionScope.emp.imgpath}";
  }
}  

function ChngPhno()
{
  var p=document.getElementById("Phno");
  if(p.style.display=='none')
  {
  p.style.display="inline";
  
  }
  else
	  p.style.display="none";
 
}  

function fun()
{
  var submitBtn = document.getElementById("r");
  submitBtn.disabled = false;
}

</script>
</head>
<body>

<form name="Update" target="_self" action="updateProfile.htm"><input
	type="button" value="Change Password" onclick="ChngPwd();"> <br />
<div id="Pwd" style="display: none">Enter new password: <input
	type='password' name='nPwd' id='nPwd'
	value="${sessionScope.emp.password}"></div>
<br />
<input type="button" value="View/Edit Address" onclick="ChngAddr();">
<br />
<div id="Address" style="display: none">Enter new address: <input
	type='text' name='nAdd' id='nAdd' value="${sessionScope.emp.address}"></div>
<br />

<input type="button" value="View/Edit Photo" onclick="ChngPic();">&nbsp;&nbsp;<br />
<img src="${sessionScope.emp.imgpath}" height="50" width="70"
	style="display: none" id="img1" /> <br />
<div id="Pic" style="display: none">Upload new Photo: <input
	type='file' name='nPic' id='nPic'></div>
<br />
<input type="button" value="View/Edit Phone No." onclick="ChngPhno();">
<br />
<div id="Phno" style="display: none">Enter new Phone No.: <input
	type='text' name='nPhno' id='nPhno' value="${sessionScope.emp.phno}"></div>
<br />
<br />
<input type="submit" value="Save"></form>
<c:choose>
	<c:when test="${empty message}"></c:when>
	<c:otherwise>
		<c:out value="${message}" />
	</c:otherwise>
</c:choose>
</body>
</html>