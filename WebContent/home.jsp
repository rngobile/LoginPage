<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home.jsp</title>
</head>
<body>
<% Object user = request.getAttribute("username"); %>
<% Object email = request.getAttribute("email"); %>
<h1>Hello <%=user%>!</h1>
Your email address is: <%=email %>

</body>
</html>