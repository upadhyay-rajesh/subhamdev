
<%

String s = request.getParameter("q1");

if (s.equals("emailid")) {

%>
Enter the id
<input type="text" name="fir" onkeyup="fun()">


<%

}


else if (s.equals("fname")) {

%>
Enter the First Name:
<input type=text name="fir" onkeyup="fun()">
<%

}


else if (s.equals("lname")) {

%>
Enter the Last Name:
<input type=text name="fir" onkeyup="fun()">
<%

}

%>

