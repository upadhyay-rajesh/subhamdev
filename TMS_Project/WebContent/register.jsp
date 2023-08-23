<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<script language="Javascript">

        function postRequest(strURL) {

	var xmlHttp;

        if (window.XMLHttpRequest) { // Mozilla, Safari, ...

         var xmlHttp = new XMLHttpRequest();

       } else if (window.ActiveXObject) { // IE

         var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

       }

    xmlHttp.open('POST', strURL, true);

    xmlHttp.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

    xmlHttp.onreadystatechange = function() {

        if (xmlHttp.readyState == 4) {
			
            updatepage(xmlHttp.responseText);

        }

    }

    xmlHttp.send(strURL);
        }
        

    function updatepage(str){
      
  
        if(str==null)
         {document.getElementById("email").value =""; 
          document.getElementById("submit").disabled=true;
         }
         else
         {
            document.getElementById("email").value =str; 
            document.getElementById("submit").disabled=false; 
            document.getElementById("email").disabled=false; 
         }
     }
    function checkfname()
    {
    	if(document.getElementById("fname").value=="")
       	{
       		document.getElementById("fname").focus();
       		return false;
       	}
       	return true;
    }
    function checklname()
    {
    	if(document.getElementById("lname").value=="")
       	{
       		document.getElementById("lname").focus();
       		return false;
       	}
       	return true;
    }
   
    function checkrid()
    {
        
    	var url="check_referal_id.htm?rid="+document.getElementById("rid").value;
    	
		var xmlHttp;
	    if (window.XMLHttpRequest)
		{
	        var xmlHttp = new XMLHttpRequest();
	     }
	     else if (window.ActiveXObject) 
		     { 
	        var xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	       }

	    xmlHttp.open('POST', url, true);
	    xmlHttp.onreadystatechange = function() 
	    {
	        if (xmlHttp.readyState == 4) 
		        {
	        	
		        	str=xmlHttp.responseText;
		        	alert(str);
	           		 if(str=="invalid")
	           		 {
	            		document.getElementById("refid").innerHTML=str;
			        	 document.getElementById("email").disabled =true; 
			        	 document.getElementById("fname").disabled=true;
			        	 document.getElementById("lname").disabled=true;
			        	 document.getElementById("password").disabled=true;
			        	 document.getElementById("phoneNo").disabled=true;
	             		document.getElementById("imgpath").disabled=true;
	             		document.getElementById("address").disabled=true;
	             		document.getElementById("submit").disabled=true;
	           		 }
	           		if(str=="valid")
	            		{
	            		alert();
	            		document.getElementById("email").disabled =false; 
			         	document.getElementById("fname").disabled=false;
			        	 document.getElementById("lname").disabled=false;
			        	 document.getElementById("password").disabled=false;
			         	document.getElementById("phoneNo").disabled=false;
	             		document.getElementById("imgpath").disabled=false;
	             		document.getElementById("address").disabled=false;
	             		
	           		 }

	       		 }
	    }
	    xmlHttp.send(null);
    
       	return true;
    }
    
        
    function generateEmail()
        {
           if(checkfname()&&checklname())
           {       	
		    var url="emailGeneration.htm?fname="+document.reg.fname.value+"&lname="+document.reg.lname.value;

	        postRequest(url);
        
           }
        }
        </script>
</head>
<body>
<form method="post" action="SaveReg.htm" name="reg">
<table border=0>
	<tr>
		<td>Referel Id :</td>
		<td><input type="text" name="rid" id="rid" onblur='Javascript:checkrid()'></td>
		<td>
		<div id="refid"></div>
		</td>
	</tr>
	
	<tr>
		<td>First Name :</td>
		<td><input type="text" name="fname" id="fname" disabled
			onblur='Javascript:checkfname()'></td>
		<td>
		<div></div>
		</td>
	</tr>
	<tr>
		<td>Last Name :</td>
		<td><input type="text" name="lname" id="lname" disabled
			onblur='Javascript:checklname()'></td>
		<td>
		<div id="emailValid"></div>
		</td>
	</tr>
	<tr>
		<td>Password :</td>
		<td><input type="password" name="password" id="password" disabled></td>
		<td>
		<div></div>
		</td>
	</tr>
	<tr>
		<td>Phone no :</td>
		<td><input type="text" name="phoneNo" id="phoneNo" disabled></td>
		<td>
		<div></div>
		</td>
	</tr>
	<tr>
		<td>Upload Your Photo:</td>
		<td><input type="file" name="imgpath" id="imgpath" disabled></td>
		<td>
		<div id=""></div>
		</td>
	</tr>
	<tr>
		<td>Address:</td>
		<td><input type="text" name="address" id="address" disabled onblur="generateEmail();"></td>
		<td>
		<div></div>
		</td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="email" id="email" disabled></td>
		<td>
		<div id="emailid"></div>
		</td>
	</tr>
</table>
<input type="submit" Value="Register" name="submit" id="submit" disabled></form>

</body>

</html>