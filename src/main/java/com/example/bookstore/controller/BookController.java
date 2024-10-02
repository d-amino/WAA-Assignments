package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class BookController {
    // Media type versioning
    @GetMapping(value = "/books",produces = "application/v1+json")
    public List<Book> getBooksV1() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1,"Learn Design Pattern","3123",200.99));
        books.add(new Book(2,"new book","8763",100.55));
        return books;
    }
    @GetMapping(value = "/books",produces = "application/v2+json")
    public List<Book> getBooksV2() {
        List<Book> books = new ArrayList<Book>();
        books.add(new Book(1,"Learn Design Pattern V2","3123",200.99));
        books.add(new Book(2,"new book v2","8763",100.55));
        return books;
    }


    //using custom header versioning
    @GetMapping(value = "/books/{id}",headers = "X-API-VERSION=1")
    public Book getBook(@PathVariable int id) {
        //pseudo - get a book by id from database
        return new Book(id,"Learn Design Pattern","3123",200.99);
    }

    @GetMapping(value = "/books/{id}",headers = "X-API-VERSION=2")
    public Book getBookV2(@PathVariable int id) {
        //pseudo - get a book by id from database
        return new Book(id,"Learn Design Pattern V2","3123",200.99);
    }

    //URI versioning
    @PostMapping("/v1/books")
    public Book addBook(@RequestBody Book book) {
        //create a new book and store into database
        return book;
    }
    @PostMapping("/v2/books")
    public Book addBookV2(@RequestBody Book book) {
        //create a new book and store into database
        return book;
    }


    //request parameter versioning
    @PutMapping(value = "/books/{id}",params = "version=1")
    public Book updateBookV1(@PathVariable int id, @RequestBody Book book) {
        //find a book by id and update
        return book;
    }

    @PutMapping(value = "/books/{id}",params = "version=2")
    public Book updateBookV2(@PathVariable int id, @RequestBody Book book) {
        //find a book by id and update
        return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        //delete a book from database by using id
        return new ResponseEntity<>("Delete book successfully", HttpStatus.OK);

    }
}
