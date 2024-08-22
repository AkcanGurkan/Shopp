package com.example.shop.service;

import com.example.shop.dto.RegisterResponseDtO;
import com.example.shop.dto.UserDtO;
import com.example.shop.entity.Role;
import com.example.shop.entity.User;
import com.example.shop.entity.Wallet;
import com.example.shop.repository.UserRepository;
import com.example.shop.security.JwtTokenProvider;
import com.example.shop.dto.LoginResponseDtO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.Console;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public RegisterResponseDtO register(UserDtO userDtO) {
        if (userRepository.findByUsername(userDtO.getUsername()).isPresent()) {
            throw new RuntimeException("Kullanıcı adı zaten mevcut: " + userDtO.getUsername());
        }

        User user = new User();
        user.setUsername(userDtO.getUsername());
        user.setEmail(userDtO.getEmail());
        user.setPassword(passwordEncoder.encode(userDtO.getPassword()));

        if (userDtO.getRole() == null) {
            throw new RuntimeException("Rol bilgisi eksik.");
        }

        user.setRole(Role.valueOf(userDtO.getRole().toUpperCase()));

        if (userDtO.getRole().equals("ROLE_CUSTOMER")) {
            user.setCustomerName(userDtO.getCustomerName());
            user.setCustomerSurname(userDtO.getCustomerSurname());
        } else if (userDtO.getRole().equals("ROLE_SELLER")) {
            user.setStoreName(userDtO.getStoreName());
        }

        Wallet wallet = new Wallet();
        wallet.setBalance(100.0);
        wallet.setUser(user);
        user.setWallet(wallet);

        String username = user.getUsername();
        String role = user.getRole().name();
        Double amount = user.getWallet().getBalance();

        userRepository.save(user);
        return new RegisterResponseDtO(username, role, amount);
    }

    public LoginResponseDtO login(UserDtO userDtO) {
        User user = userRepository.findByUsername(userDtO.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        boolean passwordMatch = passwordEncoder.matches(userDtO.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtTokenProvider.createToken(user.getUsername());
        String role = user.getRole().name();
        Double amount = user.getWallet().getBalance();
        Long id = user.getId();

        return new LoginResponseDtO(token, role, amount, id);
    }
}