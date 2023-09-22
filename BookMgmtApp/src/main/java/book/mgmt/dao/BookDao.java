package book.mgmt.dao;

import java.sql.SQLException;

import java.util.List;

import book.mgmt.entity.Book;

public interface BookDao {
	
	int addBook(Book book) throws ClassNotFoundException,SQLException;
	
	int updateBook(Book book) throws ClassNotFoundException,SQLException;
	
	int deleteBookById(int bookId) throws ClassNotFoundException,SQLException;
	
	Book getBookById(int bookId) throws ClassNotFoundException,SQLException;
	
	List<Book> getAllBooks() throws ClassNotFoundException,SQLException;
	

}
