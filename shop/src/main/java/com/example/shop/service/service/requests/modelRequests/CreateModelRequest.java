package com.example.shop.service.service.requests.modelRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateModelRequest {

    private String name;
    private int brandId;


}
