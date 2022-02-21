package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver {
    private final BookRepository bookRepository;

    public List<Book> books() {
        return bookRepository.findAll();
    }

    public Book getBook(Long id) throws Exception {
        return bookRepository.findById(id).orElseThrow(() -> new Exception("Book with id not found: " + id));
    }


}
