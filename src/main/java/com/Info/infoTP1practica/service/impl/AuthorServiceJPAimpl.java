package com.Info.infoTP1practica.service.impl;

import com.Info.infoTP1practica.domain.Author;
import com.Info.infoTP1practica.repository.author.AuthorRepository;
import com.Info.infoTP1practica.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorServiceJPAimpl implements AuthorService {
    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public Author createAuthor(Author author) {
        authorRepository.save(author);
        return author;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public boolean deleteAuthor(String name) {
        Optional<Author> authorOptional = authorRepository.findAuthorByNameEqualsIgnoreCase(name);
        if (authorOptional.isPresent()) {
            authorRepository.delete(authorOptional.get());
            return true;
        }
        return false;
    }


    @Override
    public Optional<Author> searchAuthor(String name) {
        return authorRepository.findAuthorByNameEqualsIgnoreCase(name);
    }

    @Override
    public Optional<Author> searchAuthor(String name, String lastname) {
        return  authorRepository.getAuthorByNameAndLastName(name, lastname);
    }


}
