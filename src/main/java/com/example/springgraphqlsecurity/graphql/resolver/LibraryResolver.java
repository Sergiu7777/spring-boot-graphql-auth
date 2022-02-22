package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Library;
import com.example.springgraphqlsecurity.graphql.dto.LibraryDto;
import com.example.springgraphqlsecurity.mapper.LibraryMapper;
import com.example.springgraphqlsecurity.repository.LibraryRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Component
public class LibraryResolver implements GraphQLQueryResolver {
    private final LibraryRepository libraryRepository;
    private final LibraryMapper libraryMapper;

    public List<LibraryDto> libraries() {
        return libraryRepository.findAll()
                .stream()
                .map(libraryMapper::toLibraryDto)
                .collect(Collectors.toList());
    }

    public LibraryDto getLibrary(Long id) throws Exception {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new Exception("Library with id not found: " + id));

        return libraryMapper.toLibraryDto(library);
    }
}
