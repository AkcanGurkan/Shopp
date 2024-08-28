package com.example.shop.controller;

import com.example.shop.dto.ProductDtO;
import com.example.shop.dto.PurchaseResponseDtO;
import com.example.shop.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name = "Product Controller API", description = "Operations related to products")
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Get all products.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Showed all products."),
            @ApiResponse(responseCode = "404", description = "Products not found.")
    })
    @GetMapping("/products")
    public List<ProductDtO> getAllProducts() {
        return productService.getAllProducts();
    }

    @Operation(summary = "Get product by id.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product with given id found."),
            @ApiResponse(responseCode = "404", description = "Product not found.")
    })
    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDtO> getProductById(@PathVariable Long id) {
        ProductDtO productDtO = productService.getProductById(id).orElse(null);
        return productDtO != null ? new ResponseEntity<>(productDtO, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Get product by user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User with given id found."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @GetMapping("/products/user/{username}")
    public List<ProductDtO>  getProductByUserId(@PathVariable String username) {
        return productService.getProductByUsername(username);
    }

    @Operation(summary = "Creates a new product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a product."),
            @ApiResponse(responseCode = "404", description = "Product not created.")
    })
    @PostMapping("/seller/products")
    public ProductDtO createProduct(@RequestBody ProductDtO productDTO) {
        return productService.createProduct(productDTO);
    }
    @Operation(summary = "Purchases a product.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Purchased product."),
            @ApiResponse(responseCode = "404", description = "Product not purchased.")
    })
    @PostMapping("/customer/products/purchase/{productId}/{userId}")
    public ResponseEntity<PurchaseResponseDtO> purchaseProduct(@PathVariable Long productId, @PathVariable Long userId) {
        PurchaseResponseDtO response = productService.purchaseProduct(productId, userId);
        return ResponseEntity.ok(response);
    }

}