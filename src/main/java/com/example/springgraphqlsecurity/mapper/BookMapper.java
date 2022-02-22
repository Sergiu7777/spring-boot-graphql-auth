package com.example.springgraphqlsecurity.mapper;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.entity.Library;
import com.example.springgraphqlsecurity.graphql.dto.AuthorDto;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import com.example.springgraphqlsecurity.graphql.dto.LibraryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookDto toBookDto(Book book);
    Book toBook(BookDto bookDto);

    @Mappings({@Mapping(target = "books", ignore = true)})
    AuthorDto toAuthorDto(Author author);

    @Mappings({@Mapping(target = "books", ignore = true)})
    Author toAuthor(AuthorDto authorDto);


    @Mappings({@Mapping(target = "books", ignore = true)})
    LibraryDto toLibraryDto(Library library);

    @Mappings({@Mapping(target = "books", ignore = true)})
    Library toLibrary(LibraryDto libraryDto);

}
