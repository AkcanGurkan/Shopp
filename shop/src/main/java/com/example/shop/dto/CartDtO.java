package com.example.shop.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data

public class CartDtO {

    @Schema(description = "Unique identifier of a cart", example = "1")
    private Long id;

    @Schema(description = "Unique identifier of the cart owner", example = "1")
    private Long userId;

    @Schema(description = "Items in the cart", example = "None")
    private List<CartItemDtO> items;
}
