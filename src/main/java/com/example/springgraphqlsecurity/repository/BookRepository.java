package com.example.springgraphqlsecurity.repository;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//    Book findBookByTitle(String title);

//    @Query()
//    List<Book> findAllByAuthor(Author author);

//    @Query()
//    List<Book> findAllByLibrary(Library library);
}
