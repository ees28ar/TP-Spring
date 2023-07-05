/*package com.Info.infoTP1practica.service.impl;

import com.Info.infoTP1practica.domain.Book;
import com.Info.infoTP1practica.service.BookService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;



@Service
public class BookServiceImpl implements BookService {
    Map<UUID, Book> bookMap;

    public BookServiceImpl() {
        bookMap = new HashMap<>();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        book.setAuthor("Gabriel Garcia Marquez");
        book.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        book2.setAuthor("George Orwell");
        book2.setTitle("1984");

        Book book3 = new Book();
        book3.setUuid(UUID.randomUUID());
        book3.setAuthor("Antoine de Saint-Exupery");
        book3.setTitle("El principito");

        bookMap.put(book.getUuid(), book);
        bookMap.put(book2.getUuid(), book2);
        bookMap.put(book3.getUuid(), book3);
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    @Override
    public Book createBook(Book book) {
        book.setUuid(UUID.randomUUID());
        bookMap.put(book.getUuid(), book);
        return book;
    }


    @Override
    public List<Book> obtenerLibro(String title) {
        return bookMap.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Book> updateBook(UUID uuidBook, Book bookUpdated) {
        //
        Book book = bookMap.get(uuidBook);
        if (book != null) {
            updatingBook(book, bookUpdated);
            return Optional.of(book);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteBook(String title) {
        return false;
    }



        @Override
        public Optional<Book> deleteBook(UUID idBook) {
            Book book = bookMap.get(idBook);
            if (book != null) {
                removingBook(idBook);
                return Optional.of(book);
            } else {
                return Optional.empty();
            }
        }



        private void removingBook(UUID idBook) {
            bookMap.remove(idBook);
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
*/

