package com.example.springgraphqlsecurity.graphql.dto;

import com.example.springgraphqlsecurity.entity.Book;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
public class LibraryDto {
    private Long id;
    private String address;
    private List<BookDto> books;
}
