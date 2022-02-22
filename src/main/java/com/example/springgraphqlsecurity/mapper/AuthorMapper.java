package com.example.springgraphqlsecurity.mapper;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.graphql.dto.AuthorDto;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    AuthorDto toAuthorDto(Author author);
    Author toAuthor(AuthorDto authorDto);

    @Mappings({@Mapping(target = "author.books", ignore = true)})
    BookDto toBookDto(Book book);

    @Mappings({@Mapping(target = "author.books", ignore = true)})
    Book toBook(BookDto bookDto);
}
