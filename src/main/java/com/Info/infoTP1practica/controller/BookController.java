package com.Info.infoTP1practica.controller;

import com.Info.infoTP1practica.domain.Book;
import com.Info.infoTP1practica.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController //Anotacion a nivel de clase
public class BookController {

    //IoC Inversion de control
    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //GET --> Obtener un recurso
    @GetMapping("/api/v1/book")
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    //POST --> Crear un recurso
    @PostMapping("/api/v1/book")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @GetMapping("/api/v1/books")
    public List<Book> obtenerLibro(@RequestParam(required = true, name = "title") String title) {
        return bookService.obtenerLibro(title);
    }

    //PUT Actualizar un recurso
    @PutMapping("/api/v1/book/{idBook}")
    public String updateBook(@PathVariable(value = "idBook") UUID idBook, @RequestBody Book bookUpdate) {
        Optional<Book> book = bookService.updateBook(idBook, bookUpdate);
        if (book.isEmpty()) {
            System.out.println("Book not found");
            return "Book not found";
        } else {
            System.out.println("Book not update");
            return "/api/v1/books" + book.get().getUuid();
        }
    }



    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
    }

    /*
        @DeleteMapping("/api/v1/book/{idBook}")
        public ResponseEntity<String> deleteBook(@PathVariable(value = "idBook") UUID idBook) {
            Optional<Book> book = bookService.deleteBook(idBook);
            if (book.isPresent()) {
                bookService.deleteBook(idBook);
                System.out.println("Book deleted");
                return ResponseEntity.ok("Book deleted");
            } else {
                System.out.println("Book not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
            }
        }


    @DeleteMapping("/api/v1/book/{idBook}")
    public String deleteBook(@PathVariable(value = "idBook") UUID idBook) {
        Optional<Book> book = bookService.deleteBook(idBook);
        if (book.isEmpty()) {
            System.out.println("Book not found");
            return "Book not found";
        } else {
            System.out.println("Book delete");
            return "Book delete";
        }

    }*/
}






