package com.example.shop.controller;

import com.example.shop.dto.CartDtO;
import com.example.shop.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @Operation(summary = "Get a user's cart by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Brought the cart."),
            @ApiResponse(responseCode = "404", description = "User not found or has no cart.")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<CartDtO> getCartByUserId(@PathVariable Long userId) {
        CartDtO cartDto = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cartDto);
    }

    @Operation(summary = "Creates a cart for a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a cart."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't create a cart.")
    })
    @PostMapping
    public ResponseEntity<CartDtO> createCart(@RequestBody CartDtO cartDto) {
        CartDtO newCartDto = cartService.saveCart(cartDto);
        return ResponseEntity.ok(newCartDto);
    }

    @Operation(summary = "Deletes a user's cart.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the cart."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't delete the cart.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
}
