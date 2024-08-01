package com.example.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@NoArgsConstructor
@AllArgsConstructor
public class UserDtO {

    @Schema(description = "Unique identifier of the user", example = "1")
    private Long id;

    @Schema(description = "Username of the user", example = "john_doe")
    private String username;

    @Schema(description = "Email address of the user", example = "john@example.com")
    private String email;

    @Schema(description = "Customer's first name", example = "John")
    private String customerName;

    @Schema(description = "Customer's last name", example = "Doe")
    private String customerSurname;

    @Schema(description = "Password of the user", example = "password123")
    private String password;
}