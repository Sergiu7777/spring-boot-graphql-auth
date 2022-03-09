package com.example.springgraphqlsecurity.service.impl;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import com.example.springgraphqlsecurity.mapper.BookMapper;
import com.example.springgraphqlsecurity.repository.BookRepository;
import com.example.springgraphqlsecurity.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDto> getBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) throws Exception {
        Book book = bookRepository.findById(id).orElseThrow(() -> new Exception("Book with id not found: " + id));

        return bookMapper.toBookDto(book);
    }

    @Override
    public BookDto saveBook(Book book) {
        return bookMapper.toBookDto(bookRepository.save(book));
    }
}
