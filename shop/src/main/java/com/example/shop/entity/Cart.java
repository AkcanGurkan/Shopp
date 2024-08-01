package com.example.shop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
@Table(name = "carts")
public class Cart {

    @Id
    @Schema(description = "Unique identifier of a cart", example = "1")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Unique identifier of the cart owner", example = "1")
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Schema(description = "Items in the cart", example = "None")
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items;
}