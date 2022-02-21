package com.example.springgraphqlsecurity.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Author> authors;
    private int year;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Library> libraries;
    private BigDecimal price;
}
