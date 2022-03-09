package com.example.springgraphqlsecurity.graphql.input;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class BookInput {
    private String title;
    private String isbn;
    private String description;

    private List<String> authors;
    private int year;
    private BigDecimal price;
}
