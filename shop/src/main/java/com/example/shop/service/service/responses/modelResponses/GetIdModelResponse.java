package com.example.shop.service.service.responses.modelResponses;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GetIdModelResponse {

    private int id;
    private String name;
    private String brandName;

}
