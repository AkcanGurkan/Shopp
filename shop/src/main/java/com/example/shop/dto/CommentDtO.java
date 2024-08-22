package com.example.shop.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDtO {
    private Long productId;
    private String author;
    private String content;
    private LocalDateTime date;
    private int rating;
}