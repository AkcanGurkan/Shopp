package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductDtO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stock;
    private List<String> imageUrls;
    private String ownerUsername;
    private String storeName;
    private Long categoryId;
}