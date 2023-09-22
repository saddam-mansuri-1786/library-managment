<%@page import="book.mgmt.dao.BookDaoImpl"%>
<%@page import="book.mgmt.dao.BookDao"%>
<%@page import="book.mgmt.entity.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>

<%@include file="credentials.jsp" %>

<%
BookDao bookDao= new BookDaoImpl();
String id = request.getParameter("bookId");
int bookId =Integer.parseInt(id);
Book book =bookDao.getBookById(bookId);
//out.print(book);
%>
<h1 class="h" >Update Book</h1>

<form action="updateBook" method="post" enctype="multipart/form-data">
<input  type="text" placeholder="Enter book id" name="book-id" value="<%=book.getBookId() %>"><br/><br/>
<input  type="text" placeholder="Enter book name" name="book-name" value="<%=book.getBookName() %>"><br/><br/>
<input  type="text" placeholder="Enter book price" name="book-price" value="<%=book.getBookPrice() %>"><br/><br/>
<input  type="text" placeholder="Enter no of books" name="no-of-books" value="<%=book.getNoOfBooks() %>"><br/><br/>
<input  type="file" name="book-image"><br/>
<input  class = "submite_button" type="submit"  value="Update Book"><br/>
</form>
<h4>
<%@include file="message.jsp" %>
</h4>
<h3>
<%@include file="logout.jsp" %>
</h3>
</body>
</html>