package com.Info.infoTP1practica.service;

import com.Info.infoTP1practica.domain.Author;
import com.Info.infoTP1practica.domain.Book;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {
    List<Book> getAllBooks();

    Book createBook(Book book);

    List<Book> obtenerLibro(String title);

    Optional<Book>updateBook (UUID uuidBook, Book bookUpdated);

   boolean deleteBook(String title);


}
