<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Task</title>
<script language="JavaScript" src="calendar_db.js"></script>
<link rel="stylesheet" href="calendar.css">

</head>
<body>
<form method="post" action="registerTask.htm" name="taskform">
<table>
	<caption style="font-size: 15pt">Add Task</caption>
	<tr>
		<td>Task Name:</td>
		<td><input type="text" name="taskname" /></td>
	</tr>
	<tr>
		<td>Description:</td>
		<td><input type="text" name="description" /></td>
	</tr>
	<tr>
		<td>End Date:</td>
		<td><input type="text" name="edate" /><script
			language="JavaScript">
	new tcal ({
		// form name
		'formname': 'taskform',
		// input name
		'controlname': 'edate'
	});

	</script></td>
	</tr>
	<tr>
		<td colspan="2">
		<center><input type="submit" value="Add Task" /></center>
		</td>

	</tr>
</table>
</form>
</body>
</html>