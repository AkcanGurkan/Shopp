package com.example.shop.service;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.security.JwtTokenProvider;
import io.swagger.v3.oas.annotations.media.Schema;
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

    public void register(UserDtO userDtO) {
        if (userRepository.findByUsername(userDtO.getUsername()).isPresent()) {
            throw new RuntimeException("Kullanıcı adı zaten mevcut: " + userDtO.getUsername());
        }

        User user = new User();
        user.setUsername(userDtO.getUsername());
        user.setEmail(userDtO.getEmail());
        user.setPassword(passwordEncoder.encode(userDtO.getPassword()));
        userRepository.save(user);
    }

    public String login(UserDtO userDtO) {

        User user = userRepository.findByUsername(userDtO.getUsername())
                .orElseThrow(() -> {
                    return new RuntimeException("Invalid username or password");
                });

        boolean passwordMatch = passwordEncoder.matches(userDtO.getPassword(), user.getPassword());

        if (!passwordMatch) {
            throw new RuntimeException("Invalid username or password");
        }

        String token = jwtTokenProvider.createToken(user.getUsername());

        return token;
    }
}