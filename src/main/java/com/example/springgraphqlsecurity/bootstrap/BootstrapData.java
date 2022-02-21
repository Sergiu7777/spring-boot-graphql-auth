package com.example.springgraphqlsecurity.bootstrap;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.entity.Library;
import com.example.springgraphqlsecurity.repository.AuthorRepository;
import com.example.springgraphqlsecurity.repository.BookRepository;
import com.example.springgraphqlsecurity.repository.LibraryRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final LibraryRepository libraryRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Author author = new Author(null, "Grant Cardone", new ArrayList<>());
        Library library = new Library(null, "New York", new ArrayList<>());
        Book book = new Book(null, "10X rule", "1234", List.of(author), 2012, List.of(library), new BigDecimal("20.95"));

        library.setBooks(List.of(book));
        author.setBooks(List.of(book));

        authorRepository.save(author);
        libraryRepository.save(library);
        bookRepository.save(book);
    }
}
