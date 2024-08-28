package com.example.shop.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderRequestDtO {
    private Long productId;
    private Date orderDate;

    public OrderRequestDtO(Long productId, Date orderDate) {
        this.productId = productId;
        this.orderDate = orderDate;
    }
}
