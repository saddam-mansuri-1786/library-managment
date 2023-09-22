package book.mgmt.entity;

import java.io.InputStream;
import java.time.LocalDate;

public class Book {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private LocalDate lastModificationDate;
	private int noOfBooks;
	private boolean inStock;
	private InputStream bookImage;
	
	
	public Book() {
		super();
	}

	

	public Book(int bookId, String bookName, double bookPrice, LocalDate lastModificationDate, int noOfBooks,
			boolean inStock, InputStream bookImage) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.lastModificationDate = lastModificationDate;
		this.noOfBooks = noOfBooks;
		this.inStock = inStock;
		this.bookImage = bookImage;
	}

	public Book(String bookName, double bookPrice, LocalDate lastModificationDate, int noOfBooks, boolean inStock,
			InputStream bookImage) {
		super();
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.lastModificationDate = lastModificationDate;
		this.noOfBooks = noOfBooks;
		this.inStock = inStock;
		this.bookImage = bookImage;
	}



	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	

	public LocalDate getLastModificationDate() {
		return lastModificationDate;
	}



	public void setLastModificationDate(LocalDate lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
 


	public int getNoOfBooks() {
		return noOfBooks;
	}

	public void setNoOfBooks(int noOfBooks) {
		this.noOfBooks = noOfBooks;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	public InputStream getBookImage() {
		return bookImage;
	}

	public void setBookImage(InputStream bookImage) {
		this.bookImage = bookImage;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookPrice=" + bookPrice + ", noOfBooks="
				+ noOfBooks + ", inStock=" + inStock + "]";
	}
	
	

	
}
