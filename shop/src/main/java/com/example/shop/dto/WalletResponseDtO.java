package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WalletResponseDtO {
    private String message;
    private Double amount;

    public WalletResponseDtO(String message, Double amount) {
        this.message = message;
        this.amount = amount;
    }
}
