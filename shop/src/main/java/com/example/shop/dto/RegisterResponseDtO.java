package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterResponseDtO {
    private String username;
    private String role;
    private Double amount;
    public RegisterResponseDtO(String username, String role, Double amount) {
        this.username = username;
        this.role = role;
        this.amount = amount;
    }
}