package com.shivait.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivait.Entity.Book;
import com.shivait.Repository.BookRepo;

@Service
public class BookService {
	
	    @Autowired
	    private BookRepo bookrepo;

	    public void save(Book book){
	        bookrepo.save(book);
	    }

	    public List<Book> getAllBooks(){
	        return bookrepo.findAll();
	    }

	    public Book getBookById(int id){
	        return bookrepo.findById(id).get();

	    }

	    public void deleteBookById(int id) {
	        bookrepo.deleteById(id);
	    }

}
