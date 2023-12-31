package com.ngts.scm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngts.scm.entity.Book;



public interface BookRepository extends JpaRepository<Book, Integer> {

}
