<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<HTML>
<HEAD>
<TITLE>New Document</TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<script>
		function show()
		{
				var date=new  Date();
				var a;
                var day=date.getDay();
				var mon=date.getMonth();
				var yr=date.getYear();

				var hr=date.getHours();
				var min=date.getMinutes();
				var sec=date.getSeconds();

				if (hr>=12)
				
						a="p.m.";
				else
						a="a.m.";
				if (hr>=13)
						hr-=12;
				if (min<10)
						min="0"+min;
				if (sec<10)
						sec="0"+sec;
				
                                
                         document.getElementById("result").innerHTML=hr+":"+min+":"+sec+""+a
				
                                setTimeout("show()",10);//calls show() after every second
                                                         //+""+day+"/"+mon+"/"+yr
		}
</script>
</HEAD>

<BODY onLoad="show();">
<table width="100%">
	<tr>
		<c:choose>
			<c:when test="${empty sessionScope.emp}">
			</c:when>
			<c:otherwise>
				<td align="left">Hi <c:out value="${sessionScope.emp.emailid}" /></td>
			</c:otherwise>
		</c:choose>
		<td align="right">
		<div id="result" style="text-align: right;"></div>
		</td>
	</tr>
</table>
</BODY>
</HTML>
