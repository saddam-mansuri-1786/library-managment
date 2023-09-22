<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<div class="inpt">
<%@include file="credentials.jsp" %>
<h1 class="h">Add Book</h1>

<form action="addBook" method="post" enctype="multipart/form-data">
<input type="text" placeholder="Enter book name" name="book-name"><br/><br/>
<input type="text" placeholder="Enter book price" name="book-price"><br/><br/>
<input type="text" placeholder="Enter no of books" name="no-of-books"><br/><br/>
<input type="file" name="book-image"><br/><br/>
<input type="submit"  value="Add Book"><br/><br/>
</form>
</div>
<h4>
<%@include file="message.jsp" %>
</h4>
<h3>
<%@include file="logout.jsp" %>
</h3>
</body>
</html>