<%@page import="java.time.LocalTime"%>

<%
		Integer rr=(Integer)request.getAttribute("message");
%>
	
			
		Captcha Value <input type=text value=<%= rr %> id=c disabled>
			<button type=button onClick=loadCaptcha()>Refresh</button>
			<br>Enter The Above Captcha Value <input type=text id=cc1>
		<button type=button onClick=validateCaptcha()>Validate</button>