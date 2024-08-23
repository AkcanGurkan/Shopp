package com.example.shop.service;

import com.example.shop.dto.WalletResponseDtO;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WalletService {

    private final UserRepository userRepository;

    public WalletService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public WalletResponseDtO getWalletBalance(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        BigDecimal balance = BigDecimal.valueOf(user.getWallet().getBalance());

        String message = "Hesabın güncel bakiyesi şudur:";
        Double amount = balance.doubleValue();

        return new WalletResponseDtO(message, amount);
    }

    public WalletResponseDtO updateWalletBalance(Long userId, Double amount) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        BigDecimal newBalance = BigDecimal.valueOf(amount);
        user.getWallet().setBalance(newBalance.doubleValue());

        userRepository.save(user);

        String message = "Hesabın bakiyesi başarıyla güncellendi.";

        return new WalletResponseDtO(message, amount);
    }
}