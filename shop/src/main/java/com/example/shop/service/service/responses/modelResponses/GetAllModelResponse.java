package com.example.shop.service.service.responses.modelResponses;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GetAllModelResponse {

    private int id;
    private String name;
    private String brandName;

}
