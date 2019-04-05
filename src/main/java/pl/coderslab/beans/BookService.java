package pl.coderslab.beans;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface BookService {

	 public List<Book> getList();
	 
	 public Book getBookById(int id);
	 
	 public void addBook(String isbn, String title, String author, String publisher, String type);
	 
	 public void addBook(Book book);
	 
	 public void updateBook(Book book, int id);
	 
	 public void deleteBook(int id);
	 
}
