package com.book.demo.controller;


import com.book.demo.entity.Author;
import com.book.demo.entity.Book;
import com.book.demo.repasitory.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("author")
public class AuthorRequestController {
    @Autowired
    private final AuthorRepo authorRepo;


    public AuthorRequestController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @PostMapping("/postAuthor")
    public void postAuthor(@RequestBody Author author){


        authorRepo.save(author);
    }

    @GetMapping("/getAuthor")
    public List<Author> getBook(){

        List<Author> authors = authorRepo.findAll();
        return authors;

    }

    @DeleteMapping("/deleteAuthor/{id}")
    public void deleteAuthor(@PathVariable long id){
        authorRepo.deleteById(id);
    }

    @PutMapping("/editAuthor/{id}")
    public void putAuthor(@PathVariable long id, @RequestBody Author author){
        Optional<Author> byId = authorRepo.findById(id);
        if(byId.isPresent()){
            Author author1 = byId.get();
            author1.setAuthorName(author.getAuthorName());
            authorRepo.save(author1);
        }
    }
}
