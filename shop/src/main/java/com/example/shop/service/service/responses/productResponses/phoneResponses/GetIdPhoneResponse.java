package com.example.shop.service.service.responses.productResponses.phoneResponses;

import lombok.*;

import java.math.BigDecimal;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetIdPhoneResponse {
    private int id;
    private String name;
    private String brandName;
    private String modelName;

    private Double inc;
    private Double GB;
    private Double RAM;
    private Double mAH;
    private String hatsayisi;
    private String besG;
    private String colour;
    private BigDecimal price;
}
