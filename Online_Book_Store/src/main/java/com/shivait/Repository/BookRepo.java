package com.shivait.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivait.Entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer>{

}
