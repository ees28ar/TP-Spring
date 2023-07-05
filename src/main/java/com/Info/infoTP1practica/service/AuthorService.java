package com.Info.infoTP1practica.service;

import com.Info.infoTP1practica.domain.Author;


import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);
    List<Author> getAllAuthor();

    boolean deleteAuthor (String name);

    Optional<Author> searchAuthor(String name);

    Optional<Author> searchAuthor(String name, String lastname);
}
