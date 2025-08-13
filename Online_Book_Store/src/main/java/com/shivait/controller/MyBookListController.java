package com.shivait.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivait.Service.MyBookService;

@Controller
public class MyBookListController {
	
	    @Autowired
	    private MyBookService myBookService;

	    @RequestMapping("/deleteMyBook/{id}")
	    public String deleteMyBook(@PathVariable("id") int id){
	        myBookService.deleteById(id);
	        return "redirect:/my_books";
	    }

}
