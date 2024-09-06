package com.example.shop.dto;

import lombok.Data;

@Data
public class AddToCartDto {
    private Long userId;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;

    public AddToCartDto( Long userId, Long productId, String productName, Integer quantity, Double price) {
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
}