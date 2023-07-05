package com.Info.infoTP1practica.repository.author;

import com.Info.infoTP1practica.domain.Author;
import com.Info.infoTP1practica.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, String> {
    Optional<Author> findAuthorByNameEqualsIgnoreCase(String name);

    Optional<Author> getAuthorByNameAndLastName(String name, String lastName);
}
