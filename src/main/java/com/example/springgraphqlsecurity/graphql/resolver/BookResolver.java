package com.example.springgraphqlsecurity.graphql.resolver;

import com.example.springgraphqlsecurity.entity.Book;
import com.example.springgraphqlsecurity.graphql.dto.BookDto;
import com.example.springgraphqlsecurity.graphql.input.BookInput;
import com.example.springgraphqlsecurity.mapper.BookMapper;
import com.example.springgraphqlsecurity.service.BookService;
import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import graphql.schema.DataFetchingEnvironment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@AllArgsConstructor
@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final ResourceLoader resourceLoader;

    public List<BookDto> books() {
        return bookService.getBooks();
    }

    public BookDto getBook(Long id) throws Exception {
        return bookService.getBookById(id);
    }

    public BookDto saveBook(BookInput input) throws Exception {
        Book book = new Book();
        book.setTitle(input.getTitle());
        book.setIsbn(input.getIsbn());
        book.setYear(input.getYear());

        bookService.saveBook(book);

        return bookMapper.toBookDto(book);
    }

    //TODO: create a separate resolver for uploading
    public String uploadFile(DataFetchingEnvironment environment) throws Exception {
        DefaultGraphQLServletContext context = environment.getContext();
        AtomicReference<InputStream> in = new AtomicReference<>();

        context.getFileParts().forEach(part -> {
            log.info("Uploading part: {}, size: {}", part.getSubmittedFileName(), part.getSize());
            try {
                in.set(part.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        return "downloadLink";
    }
}
