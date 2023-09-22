<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration </title>

</head>
<body>
<form action="register" method="post">
	<input  type="text" placeholder="Enter username" name="username"/><br/>
	<input  type="password" placeholder="Enter password" name="password"/><br/>
	<input  value="submit"/><br/>
</form>
<p>Already registered ? <a href="login.jsp">Go to login </a></p>

<%@include file="message.jsp" %>

</body>
</html>