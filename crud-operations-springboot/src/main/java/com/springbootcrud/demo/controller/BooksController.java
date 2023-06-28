package com.springbootcrud.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootcrud.demo.model.Books;
import com.springbootcrud.demo.service.BooksService;

@RestController
public class BooksController {

    @Autowired
    BooksService booksService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> books = booksService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{bookid}")
    public ResponseEntity<Books> getBookById(@PathVariable("bookid") int bookid) {
        try {
            Books book = booksService.getBooksById(bookid);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<Integer> saveBook(@RequestBody Books book) {
        try {
            booksService.saveOrUpdate(book);
            return new ResponseEntity<>(book.getBookid(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/books/batch")
    public ResponseEntity<List<Integer>> saveBooks(@RequestBody List<Books> booksList) {
        List<Integer> savedBookIds = new ArrayList<>();
        try {
            for (Books book : booksList) {
                booksService.saveOrUpdate(book);
                savedBookIds.add(book.getBookid());
            }
            return new ResponseEntity<>(savedBookIds, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{bookid}")
    public ResponseEntity<Books> updateBook(@PathVariable("bookid") int bookid, @RequestBody Books book) {
        try {
            booksService.update(book, bookid);
            return new ResponseEntity<>(book, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/books/{bookid}")
    public ResponseEntity<Void> deleteBook(@PathVariable("bookid") int bookid) {
        try {
            booksService.delete(bookid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
