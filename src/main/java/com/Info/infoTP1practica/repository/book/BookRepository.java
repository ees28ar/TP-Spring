package com.Info.infoTP1practica.repository.book;

import com.Info.infoTP1practica.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    //Query Methods
    Optional <Book> findBookByTitleEqualsIgnoreCase(String title);


}
