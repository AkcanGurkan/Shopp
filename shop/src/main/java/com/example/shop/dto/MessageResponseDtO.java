package com.example.shop.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class MessageResponseDtO {
    private String message;

    public MessageResponseDtO(String message) {
            this.message = message;
        }
}
