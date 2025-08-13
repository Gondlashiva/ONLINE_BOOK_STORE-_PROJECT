package com.shivait.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shivait.Entity.Book;
import com.shivait.Entity.MyBook;
import com.shivait.Service.BookService;
import com.shivait.Service.MyBookService;

@Controller
public class BookController {
	
	  @Autowired
	  private BookService bookservice;

	  @Autowired
	  private MyBookService myBookService;

	  @GetMapping("/")
	  public String Home(){
	      return "homePage.html";
	  }

	  @GetMapping("/book_register")
	  public String bookRegister(){
	      return "bookRegisterPage.html";
	  }

	  @GetMapping("/available_books")
	  public ModelAndView getAllBooks(){
	      List<Book> list=bookservice.getAllBooks();
	      ModelAndView mvc=new ModelAndView();
	      mvc.setViewName("bookListPage");
	      mvc.addObject("books",list);
	      return mvc;
	  }
	  @PostMapping("/save")
	  public String addBook(@ModelAttribute Book book){
	      bookservice.save(book);
	      return "redirect:/available_books";
	  }
	  @GetMapping("/my_books")
	  public String GetMYBooks(Model model){
	      List<MyBook> myBookList=myBookService.getAllBooks();
	      model.addAttribute("books",myBookList);
	      return "MyBookList.html";
	  }

	    @RequestMapping("/myBookList/{id}")
	    public String getMyBookList(@PathVariable("id") int id){
	        Book book = bookservice.getBookById(id);
	        MyBook myBooks = new MyBook(book.getId(), book.getName(), book.getAuthor(), book.getPrice());
	        myBookService.saveMyBooks(myBooks);
	        return "redirect:/my_books";
	    }
	    @RequestMapping("/editBook/{id}")
	    public String editBook(@PathVariable("id") int id, Model model){
	        Book book = bookservice.getBookById(id);
	        model.addAttribute("book", book);
	        return "bookEdit.html";
	    }
	    @RequestMapping("/deleteBook/{id}")
	    public String deleteBook(@PathVariable("id") int id){
	        bookservice.deleteBookById(id);
	        return "redirect:/available_books";
	    }

	}
