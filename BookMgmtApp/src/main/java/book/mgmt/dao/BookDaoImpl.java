package book.mgmt.dao;

import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import book.mgmt.entity.Book;
import book.mgmt.utils.DBUtils;

public class BookDaoImpl implements BookDao {

	
		
	//`book_id`, `book_name`, `book_price`, `last_modification_date`, `no_of_books`, `inStock`, `book_image`
	
	private final String INSERT_BOOK = "INSERT INTO books"
			+ "(book_name, book_price, last_modification_date, no_of_books, inStock, book_image) "
			+ "VALUES(?,?,?,?,?,?)";
	
	private final String UPDATE_BOOK = "UPDATE books SET "
			+ "book_name=?, book_price=?, last_modification_date=?, "
			+ "no_of_books=?, inStock=?, book_image=? WHERE book_id=?";
			
	private final String DELETE_BOOK = "DELETE  FROM books WHERE book_id=?";
	
	private final String GET_ON_BOOK ="SELECT * FROM books WHERE book_id=?";
	
	private final String GET_ALL_BOOK = "SELECT * FROM books";

private Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(DBUtils.DRIVER);
		Connection con = DriverManager.getConnection(DBUtils.URL,DBUtils.USERNAME,DBUtils.PASSWORD);
		return con;
	}
	
	
	@Override
	public int addBook(Book book) throws ClassNotFoundException, SQLException {

		int result = 0;

		try (
				Connection con = getConnection(); 
				PreparedStatement pStmt = con.prepareStatement(INSERT_BOOK)) {

			pStmt.setString(1, book.getBookName());
			pStmt.setDouble(2, book.getBookPrice());
			pStmt.setDate(3, Date.valueOf(book.getLastModificationDate()));
			pStmt.setInt(4, book.getNoOfBooks());
			//int noOfBook = book.getNoOfBooks();
			//boolean inStock = noOfBook > 0;

			pStmt.setBoolean(5, book.isInStock());
			pStmt.setBlob(6, book.getBookImage());

			result = pStmt.executeUpdate();

		}
		return result;
	}

	

	@Override
	public int updateBook(Book book) throws ClassNotFoundException, SQLException {
		
		int result=0;
		
		try(	Connection con = getConnection();
			PreparedStatement pStmt = con.prepareStatement(UPDATE_BOOK);
			){

			pStmt.setString(1, book.getBookName());
			pStmt.setDouble(2, book.getBookPrice());
			pStmt.setDate(3,Date.valueOf(book.getLastModificationDate()));
			
			int noOfBook = book.getNoOfBooks();
			boolean inStock = noOfBook>0;
			
			pStmt.setInt(4, book.getNoOfBooks());
			pStmt.setBoolean(5, book.isInStock());
			pStmt.setBlob(6, book.getBookImage());
			pStmt.setInt(7, book.getBookId());
			result=pStmt.executeUpdate();
			
		}
		return result;
	}

	@Override
	public int deleteBookById(int bookId) throws ClassNotFoundException, SQLException {

		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pStmt = con.prepareStatement(DELETE_BOOK);) {

			pStmt.setInt(1, bookId);
			result = pStmt.executeUpdate();
		}

		return result;
	}   

	@Override
	public Book getBookById(int bookId) throws ClassNotFoundException, SQLException {

		Book book = null;
		ResultSet rSet = null;

		try (
				Connection con = getConnection(); 
				PreparedStatement pStmt = con.prepareStatement(GET_ON_BOOK);
			)
		{
			pStmt.setInt(1, bookId);
			rSet = pStmt.executeQuery();

			if (rSet.next()) {
				int id = rSet.getInt("book_id");
				String name = rSet.getString("book_name");
				double price = rSet.getDouble("book_price");

				// java.sql.Date -> LocalDate

				Date d =rSet.getDate("last_modification_date");
				LocalDate lastModificationDate = d.toLocalDate();
				

				int no = rSet.getInt("no_of_books");

				boolean inStock = rSet.getBoolean("inStock");

				
				Blob blob =  rSet.getBlob("book_image");
				
			
				InputStream image = blob.getBinaryStream();

				book = new Book(id, name, price,lastModificationDate , no, inStock, image);

			}
		} finally {
			if (rSet != null)
				rSet.close();
		}
		return book;
	}

	

	@Override
	public List<Book> getAllBooks() throws ClassNotFoundException, SQLException {
		
		List<Book> booklist = new ArrayList<Book>();
		Book book =null;
		
		try (Connection con = getConnection(); 
				Statement stmt = con.createStatement();
				ResultSet rSet = stmt.executeQuery(GET_ALL_BOOK);
				
				){

			while (rSet.next()) {
				int id = rSet.getInt("book_id");
				String name = rSet.getString("book_name");
				double price = rSet.getDouble("book_price");

				// java.sql.Date -> LocalDate

				Date date = rSet.getDate("last_modification_date");
				LocalDate lastmodificationdate = date.toLocalDate();

				int no = rSet.getInt("no_of_books");

				boolean inStock = rSet.getBoolean("inStock");

				Blob blob = (Blob) rSet.getBlob("book_image");
				InputStream image = blob.getBinaryStream();

				book = new Book(id, name, price, lastmodificationdate, no, inStock, image);
				booklist.add(book);
			}
		} 
		
		return booklist;
	}

}
