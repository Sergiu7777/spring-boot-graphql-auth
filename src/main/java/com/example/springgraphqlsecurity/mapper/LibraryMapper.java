package com.example.springgraphqlsecurity.mapper;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.entity.Library;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import com.example.springgraphqlsecurity.graphql.dto.LibraryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface LibraryMapper {
    LibraryMapper INSTANCE = Mappers.getMapper(LibraryMapper.class);

    LibraryDto toLibraryDto(Library library);
    Library toLibrary(LibraryDto libraryDto);

    @Mappings({@Mapping(target = "library.books", ignore = true)})
    BookDto toBookDto(Book book);

    @Mappings({@Mapping(target = "library.books", ignore = true)})
    Book toBook(BookDto bookDto);
}
