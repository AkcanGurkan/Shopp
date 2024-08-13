package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponseDtO {
    private String token;
    private String role;

    public LoginResponseDtO(String token, String role) {
        this.token = token;
        this.role = role;
    }
}