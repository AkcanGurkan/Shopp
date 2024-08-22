package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDtO {
    private String token;
    private String role;
    private Double amount;
    private Long id;

    public LoginResponseDtO(String token, String role, Double amount, Long id) {
        this.token = token;
        this.role = role;
        this.amount = amount;
        this.id = id;
    }
}