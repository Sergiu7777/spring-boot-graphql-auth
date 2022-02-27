package com.example.springgraphqlsecurity.graphql.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String isbn;
    private String description;

    private List<AuthorDto> authors;
    private int year;
    private List<LibraryDto> libraries;
    private BigDecimal price;
}
