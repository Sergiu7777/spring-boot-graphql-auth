package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Author;
import com.example.springgraphqlsecurity.graphql.dto.AuthorDto;
import com.example.springgraphqlsecurity.mapper.AuthorMapper;
import com.example.springgraphqlsecurity.repository.AuthorRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@AllArgsConstructor
@Component
public class AuthorResolver implements GraphQLQueryResolver {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorDto> authors() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toAuthorDto)
                .collect(Collectors.toList());
    }

    public AuthorDto getAuthor(Long id) throws Exception {
        Author author = authorRepository.findById(id).orElseThrow(() -> new Exception("Author with id not found: " + id));

        return authorMapper.toAuthorDto(author);
    }
}
