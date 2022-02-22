package com.example.springgraphqlsecurity.graphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AuthorDto {
    private Long id;
    private String fullName;
    private List<BookDto> books;
}
