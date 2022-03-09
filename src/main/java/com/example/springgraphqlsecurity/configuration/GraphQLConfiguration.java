package com.example.springgraphqlsecurity.configuration;

import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public GraphQLScalarType uploadScalar() {
        return ApolloScalars.Upload;
    }
}
