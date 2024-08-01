package com.example.shop.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cart_items")
public class CartItem {
    @Schema(description = "Unique identifier of a cart item.", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Unique identifier of a cart.", example = "1")
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Schema(description = "Unique identifier of a product.", example = "1")
    @Column(name = "product_id")
    private Long productId;

    @Schema(description = "Quantity of the product.", example = "1")
    @Column(name = "quantity")
    private int quantity;
}