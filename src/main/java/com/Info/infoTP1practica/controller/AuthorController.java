package com.Info.infoTP1practica.controller;

import com.Info.infoTP1practica.domain.Author;
import com.Info.infoTP1practica.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class AuthorController {
    AuthorService authorService;


    @PostMapping("/api/v1/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);

    }

    @GetMapping("/api/v1/author")
    public List<Author> getAllAuthor() {
        return authorService.getAllAuthor();
    }


    @DeleteMapping("/api/v1/author/{nameAuthor}")
    public String deleteAuthor(@PathVariable(value = "nameAuthor") String nameAuthor) {
        boolean deleted = authorService.deleteAuthor(nameAuthor);
        if (deleted) {
            System.out.println("Author deleted");
            return "Author deleted";
        } else {
            System.out.println("Author not found");
            return "Author not found";
        }
    }

    @GetMapping("/api/v1/author/{nameAuthor}")
    public Optional<Author> searchAuthor(@PathVariable(value = "nameAuthor") String nameAuthor) {
        Optional<Author> author = authorService.searchAuthor(nameAuthor);
        if (author.isPresent()) {
            return author;
        } else {
            System.out.println("Author not found");
            return Optional.empty();
        }
    }
    @GetMapping("/api/v1/author/{name}/{lastname}")
    public Optional<Author> getAuthorByNameAndLastName(@PathVariable("name") String name, @PathVariable("lastname") String lastname) {
        Optional<Author> author = authorService.searchAuthor(name, lastname);
        if (author.isPresent()) {
            return author;
        } else {
            System.out.println("Author not found");
            return Optional.empty();
        }
    }


        /*
        @GetMapping("/api/v1/author/{nameAuthor}")
    public List<Author> searchAuthor(@PathVariable(value = "nameAuthor") String nameAuthor) {
        List<Author> authors = authorService.searchAuthor(nameAuthor);
        if (!authors.isEmpty()) {
            return authors;
        } else {
            System.out.println("Author not found");
            return "Author not found";
        }
         */

        /*
           @GetMapping("/api/v1/author/{nameAuthor}")
           String searchAuthor(@PathVariable(value = "nameAuthor") String nameAuthor)
           boolean search = authorService.searchAuthor(nameAuthor);
           if (search) {
             return authorService.getAuthor();
        } else {
            System.out.println("Author not found");
            return "Author not found";
        }

            public List<Book> obtenerLibro(@RequestParam(required = true, name = "title") String title) {
        return bookService.obtenerLibro(title);
    }
         */

    }
