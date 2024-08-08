package com.example.shop.config;

import io.swagger.v3.oas.annotations.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "E-commerce API",
                version = "1.0",
                description = "API documentation for the e-commerce application"
        ),
        servers = {
                @Server(url = "http://localhost:8080", description = "Local server")
        }
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("springshop-public")
                .pathsToMatch("/users/**", "/carts/**", "/auth/**")
                .build();
    }
}