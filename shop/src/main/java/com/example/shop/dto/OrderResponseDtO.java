package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class OrderResponseDtO {
    private Long id;
    private LocalDateTime orderDate;
    private Long customerId;
    private Long sellerId;
    private Long productId;
    private String status;
    public OrderResponseDtO(Long id, LocalDateTime orderDate, Long customerId, Long sellerId, Long productId, String status){
        this.id = id;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.status = status;
    }
}
