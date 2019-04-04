package pl.coderslab.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.coderslab.beans.Book;
import pl.coderslab.beans.MemoryBookService;

@RestController
@RequestMapping("/books")
    public class BookController {
		@Autowired
		MemoryBookService memoryBookService;
	
        @RequestMapping("/hello")
        public String hello(){
            return "{hello: World}";
        }
        
        @RequestMapping("/helloBook")
        public Book helloBook(){
        	return new Book(1L,"9788324631766","Thinking in Java",
                            "Bruce Eckel","Helion","programming");
        }
        
        @RequestMapping(value = "/", method = RequestMethod.GET)
        public List<Book> getBooks(){
        	return memoryBookService.readBooks();
        }
        
    	@RequestMapping("/cart")
    	@ResponseBody
    	public String cart() {
    		return cart.readCart().toString();
    	}
        
    }
