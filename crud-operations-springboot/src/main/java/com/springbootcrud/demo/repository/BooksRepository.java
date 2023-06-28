package com.springbootcrud.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.springbootcrud.demo.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

}
