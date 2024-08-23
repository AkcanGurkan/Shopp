package com.example.shop.controller;

import com.example.shop.dto.PurchaseResponseDtO;
import com.example.shop.dto.UserDtO;
import com.example.shop.dto.WalletResponseDtO;
import com.example.shop.service.WalletService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@Tag(name = "Wallet Controller API", description = "Operations related to wallets")
@RequestMapping("/wallet")
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
    @GetMapping("/{userId}")
    public ResponseEntity<WalletResponseDtO> getWalletBalance(@PathVariable Long userId) {
        WalletResponseDtO response = walletService.getWalletBalance(userId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<WalletResponseDtO> updateWalletBalance(@PathVariable Long userId, @RequestBody Double amount) {
        WalletResponseDtO response = walletService.updateWalletBalance(userId, amount);
        return ResponseEntity.ok(response);
    }
}
