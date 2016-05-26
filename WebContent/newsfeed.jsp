<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.servlet.hello.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<% User u = (User)session.getAttribute("user"); %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width: 100%">
		<tr>
			<th>Name</th>
			<th>Story</th>
			<th>Date</th>
		</tr>
		<tr>
			<td><center><%= u.getUserName() %></td>
			<td><center>Hello Table!</td>
			<td><center>March 25, 2016</td>
		</tr>
	</table>
</body>
</html>