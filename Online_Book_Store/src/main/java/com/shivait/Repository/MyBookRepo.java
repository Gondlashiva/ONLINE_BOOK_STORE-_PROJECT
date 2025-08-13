package com.shivait.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shivait.Entity.MyBook;

public interface MyBookRepo extends JpaRepository<MyBook,Integer> {

}
