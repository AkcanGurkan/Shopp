package com.example.shop.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import com.example.shop.entity.Role;

@Data
@Entity
@Configuration
@Table(name = "users")
public class User {
    @Schema(description = "Unique identifier of the user", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Username of the user", example = "john_doe")
    @Column(unique = true)
    private String username;

    @Schema(description = "Password of the user", example = "password123")
    private String password;

    @Schema(description = "Email address of the user", example = "john@example.com")
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Schema(description = "Customer's first name", example = "John")
    private String customerName;

    @Schema(description = "Customer's last name", example = "Doe")
    private String customerSurname;

    private String storeName;

    @Schema(description = "Cart of the user", example = "None")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;
}