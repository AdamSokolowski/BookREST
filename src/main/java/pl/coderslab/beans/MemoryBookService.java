package pl.coderslab.beans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemoryBookService implements BookService{
    private List<Book> list;
    private int lastId = 0;
    public MemoryBookService() {
        list = new ArrayList<Book>();
        
        addBook("9788324631766", "Thinking in Java", "Bruce Eckel",
                    "Helion", "programming");
        addBook("9788324627738", "Rusz glowa, Java.",
                    "Sierra Kathy, Bates Bert", "Helion", "programming");
        addBook("9780130819338", "Java 2. Podstawy",
                    "Cay Horstmann, Gary Cornell", "Helion", "programming");
    }
    public List<Book> getList() {return list;}
    public void setList(List<Book> list) {
    	this.list = list;
    }
    public Book getBookById(int id) {
    	int listIndex = findBookListItemById(id);
    	if (listIndex==-1) {
    		return null;
    	}
    	return list.get(listIndex);
    }
    
    private int findBookListItemById(int id) {
    	int i=0;
    	while(list.get(i).getId()<id && i<list.size()-1) {
    		i++;
    	}
    	if(list.get(i).getId()==id) {
    		return i;
    	}
    	return -1;
    }
    
    public void addBook(String isbn, String title, String author, String publisher, String type) {
    	lastId++;
    	list.add(new Book(lastId, isbn, title, author, publisher, type));
    }
    
    public void addBook(Book book) {
    	list.add(book);
    }
    
    public void updateBook(Book book, int id) {
    	int listIndex = findBookListItemById(id);
    	if(listIndex>-1)
    		list.set(listIndex, book);
    }
    
    public void deleteBook(int id) {
    	int listIndex = findBookListItemById(id);
    	if (listIndex >-1)
    		list.remove(listIndex);
    	
    }
    
}

