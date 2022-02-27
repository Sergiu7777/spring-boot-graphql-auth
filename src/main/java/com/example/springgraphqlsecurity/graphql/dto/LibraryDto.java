package com.example.springgraphqlsecurity.graphql.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LibraryDto {
    private Long id;
    private String address;
    private String email;
    private String phone;
    private List<BookDto> books;
}
