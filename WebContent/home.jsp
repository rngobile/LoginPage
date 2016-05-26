<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.servlet.hello.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home.jsp</title>
</head>
<body>

<!-- This was assigned from using request  
<%Object user = request.getAttribute("username");%>
<%Object email = request.getAttribute("email");%>
-->

	<!-- This is where we assigned from session -->
	<%
		User u = (User) session.getAttribute("user");
	%>

	<h1>
		Hello
		<%=u.getUserName()%>!
	</h1>
	Your email address is:
	<%=u.getEmail()%>
	<br>
	<form action="newsfeed.jsp">
		<input type="submit" value="Newsfeed">
	</form>
	<form action="LoginServletPost" method="post">
		<input type="hidden" name="action" id="action" value="logout">
		<input type="submit" value="Logout">
	</form>
</body>
</html>