
<%@page import="book.mgmt.utils.Utility"%>
<%@ page import="book.mgmt.dao.BookDao"%>
<%@ page import="book.mgmt.dao.BookDaoImpl"%>
<%@ page import="book.mgmt.entity.Book"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Dash-Board</title>

<link rel="stylesheet" type="text/css" href="css/style.css"/>
</head>
<body>
<%@include file="credentials.jsp" %>
	<%
	BookDao bookDao = new BookDaoImpl();
	List<Book> booklist = bookDao.getAllBooks();
	//out.print(booklist);
	%>

	<table class="table1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Price</th>
			<th>Pieces</th>
			<th>Availability</th>
			<th>Date</th>
			<th>Image</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<%
		for (Book book : booklist) {
			String Availability = book.isInStock() ? "Available" : "Not Available";
		%>


		<tr>
			<td><%= book.getBookId() %></td>
			<td><%= book.getBookName() %></td>
			<td><%= book.getBookPrice() %></td>
			<td><%= book.getNoOfBooks() %></td>
			<td><%= Availability %></td>
			<td><%= book.getLastModificationDate()%></td>
			
<td><img src="data:image/jpg;base64,<%= Utility.displayImage(book.getBookImage())%>" width="50" height="80"></td>
			
			
			<td><a href="book_update.jsp?bookId=<%=book.getBookId()%>">Update Book</a>  </td>
			<td> <a href="deleteBook?bookId=<%= book.getBookId() %>">Delete Book</a> </td>
		</tr>
		<%
		}
		%>

		<tr>
			<td colspan="9"><a href="book_add.jsp">Add Book</a></td>

		</tr>

	</table>

<h4>	
<%@include file="message.jsp" %>
</h4>
<h3>
<%@include file="logout.jsp" %>
</h3>
</body>
</html>