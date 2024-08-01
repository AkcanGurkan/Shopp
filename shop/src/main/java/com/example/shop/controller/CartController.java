package com.example.shop.controller;

import com.example.shop.entity.Cart;
import com.example.shop.entity.CartItem;
import com.example.shop.service.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Cart Controller API", description = "Operations related to carts")
@RequestMapping("/carts")
public class CartController {
    @Autowired
    private CartService cartService;

    @Operation(summary = "Get a users cart by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Bringed the cart."),
            @ApiResponse(responseCode = "404", description = "User not found or has no cart.")
    })
    @GetMapping("/user/{userId}")
    public ResponseEntity<Cart> getCartByUserId(@PathVariable Long userId) {
        Cart cart = cartService.getCartByUserId(userId);
        return ResponseEntity.ok(cart);
    }
    @Operation(summary = "Creates a cart for a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a cart."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't create a cart.")
    })
    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart) {
        Cart newCart = cartService.saveCart(cart);
        return ResponseEntity.ok(newCart);
    }

    @Operation(summary = "Delete a users cart.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the cart."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't delete the cart.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.deleteCart(id);
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Add a cart item.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added an item."),
            @ApiResponse(responseCode = "404", description = "Item couldn't add.")
    })
    @PostMapping("/items")
    public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem) {
        CartItem newCartItem = cartService.addCartItem(cartItem);
        return ResponseEntity.ok(newCartItem);
    }

    @Operation(summary = "Delete a cart item.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted a cart item."),
            @ApiResponse(responseCode = "404", description = "Item couldn't delete.")
    })
    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> removeCartItem(@PathVariable Long id) {
        cartService.removeCartItem(id);
        return ResponseEntity.noContent().build();
    }
}