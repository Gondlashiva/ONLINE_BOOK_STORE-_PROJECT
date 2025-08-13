package com.shivait.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivait.Entity.MyBook;
import com.shivait.Repository.MyBookRepo;

@Service
public class MyBookService {
	
	@Autowired
    private MyBookRepo myBookRepo;


    public void saveMyBooks(MyBook book){
           myBookRepo.save(book);
    }

    public List<MyBook> getAllBooks(){
        return myBookRepo.findAll();
    }

    public void deleteById(int id){
        myBookRepo.deleteById(id);
    }

}
