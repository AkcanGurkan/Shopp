package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderPutRequestDtO {
    private Long userId;
    private String orderStatus;

    public OrderPutRequestDtO(Long userId, String orderStatus) {
        this.userId = userId;
        this.orderStatus = orderStatus;
    }
}
