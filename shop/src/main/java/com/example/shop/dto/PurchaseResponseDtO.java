package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseResponseDtO {
    private String message;

    public PurchaseResponseDtO(String message) {
        this.message = message;
    }
}
