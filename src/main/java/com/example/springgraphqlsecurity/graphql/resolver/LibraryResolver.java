package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Library;
import com.example.springgraphqlsecurity.repository.LibraryRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class LibraryResolver implements GraphQLQueryResolver {
    private final LibraryRepository libraryRepository;

    public List<Library> libraries() {
        return libraryRepository.findAll();
    }

    public Library getLibrary(Long id) throws Exception {
        return libraryRepository.findById(id).orElseThrow(() -> new Exception("Library with id not found: " + id));
    }
}
