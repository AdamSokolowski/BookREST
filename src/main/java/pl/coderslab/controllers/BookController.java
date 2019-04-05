package pl.coderslab.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.beans.Book;
import pl.coderslab.beans.BookService;

@RestController
@RequestMapping("/books")
    public class BookController {
		@Autowired
		BookService bookService;
        
        @RequestMapping("/helloBook")
        public Book helloBook(){
        	return new Book(1,"9788324631766","Thinking in Java",
                            "Bruce Eckel","Helion","programming");
        }
        
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public List<Book> getBooks(){
        	return bookService.getList();
        }
        
        @RequestMapping(value = "/{id}")
        public Book getBookById(@PathVariable int id) {
        	return bookService.getBookById(id);
        }
        
        @RequestMapping(value = "/", method = RequestMethod.POST)
        public void addBook(@RequestBody Book book) {
        	bookService.addBook(book);
        }
        
        @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
        public void updateBook(@RequestBody Book book, @PathVariable int id) {
        	bookService.updateBook(book, id);
        }
        
        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public void updateBook(@PathVariable int id) {
        	bookService.deleteBook(id);
        }      
        
    	/*@RequestMapping("/cart")
    	@ResponseBody
    	public String cart() {
    		return cart.readCart().toString();
    	}*/
        
    }
