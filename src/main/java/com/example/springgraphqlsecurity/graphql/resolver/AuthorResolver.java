package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class AuthorResolver implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;

    public List<Author> authors() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Long id) throws Exception {
        return authorRepository.findById(id).orElseThrow(() -> new Exception("Author with id not found: " + id));
    }
}
