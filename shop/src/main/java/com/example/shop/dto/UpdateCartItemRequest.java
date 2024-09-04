package com.example.shop.dto;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
    private Long userId;
    private Long productId;
    private int quantity;
}