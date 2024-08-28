package com.example.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CartItemDtO {
    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
}
