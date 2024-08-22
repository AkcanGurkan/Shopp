package com.example.shop.entity;

import jakarta.persistence.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Entity
@Table(name = "wallets")
public class Wallet {
    @Schema(description = "Unique identifier of the wallet", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Balance in the wallet", example = "100.00")
    private double balance;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}