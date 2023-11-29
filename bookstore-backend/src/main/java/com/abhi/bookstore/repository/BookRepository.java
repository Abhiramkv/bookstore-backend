package com.abhi.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhi.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
