<%@page import="com.facebookweb.entity.Country"%>
<%@page import="java.util.List"%>
<%
		List<Country> email=(List<Country>)request.getAttribute("message");
%>
		
			<select>
			<%
			for (Country cc : email) { %>
				<option><%= cc.getCountryName() %></option>

		<%	}
		%>
			</select>
