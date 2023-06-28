package com.springbootcrud.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.demo.model.Books;
import com.springbootcrud.demo.service.BooksService;

//mark class as controller
@RestController
public class BooksController {
   
	//autowire the BooksService class  
	@Autowired  
	BooksService booksService;  
	//creating a get mapping that retrieves all the books detail from the database   
	@GetMapping("/book")  
	private List<Books> getAllBooks()   
	{  
	return booksService.getAllBooks();  
	}  
	//creating a get mapping that retrieves the detail of a specific book  
	@GetMapping("/book/{bookid}")  
	private Books getBooks(@PathVariable("bookid") int bookid)   
	{  
	return booksService.getBooksById(bookid);  
	}  
	//creating a delete mapping that deletes a specified book  
	@DeleteMapping("/book/{bookid}")  
	private void deleteBook(@PathVariable("bookid") int bookid)   
	{  
	booksService.delete( bookid);  
	}  
	//creating post mapping that post the book detail in the database  
//	@PostMapping("/books")  
//	private int saveBook(@RequestBody Books books)   
//	{  
//	booksService.saveOrUpdate(books);  
//	return books.getBookid();  
//	}  
	//create books, in json format using array format
//	@PostMapping("/books")
//	private List<Integer> saveBooks(@RequestBody List<Books> booksList) {
//	    List<Integer> savedBookIds = new ArrayList<>();
//	    for (Books books : booksList) {
//	        booksService.saveOrUpdate(books);
//	        savedBookIds.add(books.getBookid());
//	    }
//	    return savedBookIds;
//	}
//	
	
	// Modify the saveBooks method in BooksController class
	@PostMapping("/books")
	private List<Integer> saveBooks(@RequestBody List<Books> booksList) {
	    List<Integer> savedBookIds = new ArrayList<>();
//	    int bookid = 1; // Initial bookid value
	    for (Books books : booksList) {
//	        books.setBookid(bookid);
	        booksService.saveOrUpdate(books);
	        savedBookIds.add(books.getBookid());
//	        bookid += 10; // Increment bookid by 10 for the next record
	    }
	    return savedBookIds;
	}
	//creating put mapping that updates the book detail   
	@PutMapping("/books")  
	private Books update(@RequestBody Books books)   
	{  
	booksService.saveOrUpdate(books);  
	return books;  
	}  
}
