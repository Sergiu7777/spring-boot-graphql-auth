package com.example.springgraphqlsecurity.service;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;

import java.util.List;

public interface BookService {

    public List<BookDto> getBooks();

    public BookDto getBookById(Long id) throws Exception;

    public BookDto saveBook(Book book);
}
