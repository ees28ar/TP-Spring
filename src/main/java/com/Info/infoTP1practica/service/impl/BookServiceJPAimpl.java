package com.Info.infoTP1practica.service.impl;

import com.Info.infoTP1practica.domain.Author;
import com.Info.infoTP1practica.domain.Book;
import com.Info.infoTP1practica.repository.author.AuthorRepository;
import com.Info.infoTP1practica.repository.book.BookRepository;
import com.Info.infoTP1practica.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
@Primary
public class BookServiceJPAimpl implements BookService {


    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> obtenerLibro(String title) {
        return null;
    }

    @Override
    @Transactional
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        Optional<Book> bookOptional = bookRepository.findById(uuidBook);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            updatingBook(book, bookUpdated);
            return Optional.of(bookRepository.save(book));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(String title) {
        Optional<Book> bookOptional = bookRepository.findBookByTitleEqualsIgnoreCase(title);
        if (bookOptional.isPresent()) {
            bookRepository.delete(bookOptional.get());
            return true;
        }
        return false;
    }


    private void updatingBook(Book book, Book bookUpdated) {
        if (bookUpdated.getTitle() != null) {
            book.setTitle(bookUpdated.getTitle());
        }
        if (bookUpdated.getAuthor() != null) {
            book.setAuthor(bookUpdated.getAuthor());
        }
    }
}
