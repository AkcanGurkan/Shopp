package com.example.shop.service.service.requests.productRequests.tvRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateTvRequest {

    private int brandId;
    private int modelId;

    private Double inc;
    private Double GB;
    private Double RAM;
    private Double mAH;
    private String hatsayisi;
    private String besG;
    private String colour;
    private BigDecimal price;
}
