package com.example.springgraphqlsecurity.service.impl;

import com.example.springgraphqlsecurity.repository.BookRepository;
import com.example.springgraphqlsecurity.service.LibraryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class LibraryServiceImpl implements LibraryService {
    private final BookRepository bookRepository;


}
