package com.book.demo.controller;


import com.book.demo.entity.Book;
import com.book.demo.repasitory.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("book")
public class BookRequestController {

    private final BookRepo bookRepo;

    @Autowired
    public BookRequestController(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @PostMapping("/postBook")
    public void postBook(@RequestBody Book bookReq){
        bookRepo.save(bookReq);
    }

    @GetMapping("/getBook")
    public List<Book> getBook(){

        List<Book> books = bookRepo.findAll();
        return books;

    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable long id){
        bookRepo.deleteById(id);
    }

    @PutMapping("/editBook/{id}")
    public void putBook(@PathVariable long id, @RequestBody Book bookReq){
        Optional<Book> byId = bookRepo.findById(id);
        if(byId.isPresent()){
            Book book = byId.get();
            book.setBookName(bookReq.getBookName());
            book.setPrice(bookReq.getPrice());
            bookRepo.save(book);
        }
    }






























}
