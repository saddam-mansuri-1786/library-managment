package book.mgmt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import book.mgmt.dao.BookDao;
import book.mgmt.dao.BookDaoImpl;

@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String message = "";

		try {
			BookDao bookDao = new BookDaoImpl();
			String id = request.getParameter("bookId");
			int bookId = Integer.parseInt(id);
			int result = bookDao.deleteBookById(bookId);
			message = "";

			if (result > 0) {
				response.sendRedirect("book_dashboard.jsp? message= Book Deleted successfully");
			} else {
				response.sendRedirect("book_dashboard.jsp? message= Book cannot be Deleted");  
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			message = "Book cannot be Deleted ";		}
	}

}
