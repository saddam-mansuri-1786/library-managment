<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

<div class="form">
<form  action="login" method="post">
<h1 > Book Management App</h1><br/>
<h2 >Login Here</h2><br/>

	<input style="background-color : #bbbbbb" class = "form" type="text" placeholder="Enter username" name="username"/><br/><br/>
	<input style="background-color : #bbbbbb" class = "form" type="password" placeholder="Enter password" name="password"/><br/><br/>
	<input class = "submite_button" type="submit" value="Login"/><br/>
</form>

<p>Not a registered user? <a href="registration.jsp">Register here </a></p>
<h4>
<%@include file="message.jsp" %></h4>
</div>
</body>
</html>