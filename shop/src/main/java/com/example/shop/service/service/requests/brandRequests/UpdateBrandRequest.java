package com.example.shop.service.service.requests.brandRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateBrandRequest {

    private int id;
    private String name;


}
