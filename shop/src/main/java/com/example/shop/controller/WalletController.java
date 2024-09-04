package com.example.shop.controller;

import com.example.shop.dto.WalletResponseDtO;
import com.example.shop.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Tag(name = "Wallet Controller API", description = "Operations related to wallets")
@RequestMapping("/api")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }


    @Operation(summary = "Get user wallet by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @GetMapping("/wallet/{userId}")
    public ResponseEntity<WalletResponseDtO> getWalletBalance(@PathVariable Long userId) {
        WalletResponseDtO response = walletService.getWalletBalance(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/wallet/{userId}")
    public ResponseEntity<WalletResponseDtO> updateWalletBalance(@PathVariable Long userId, @RequestBody Double amount) {
        WalletResponseDtO response = walletService.updateWalletBalance(userId, amount);
        return ResponseEntity.ok(response);
    }
}
