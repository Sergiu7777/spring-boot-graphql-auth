package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import com.example.springgraphqlsecurity.mapper.BookMapper;
import com.example.springgraphqlsecurity.repository.BookRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> books() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    public BookDto getBook(Long id) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book with id not found: " + id));

        return bookMapper.toBookDto(book);
    }


}
