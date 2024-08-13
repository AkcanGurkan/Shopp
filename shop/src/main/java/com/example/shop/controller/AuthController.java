package com.example.shop.controller;

import com.example.shop.dto.LoginResponseDtO;
import com.example.shop.dto.UserDtO;
import com.example.shop.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication", description = "Authentication API")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Register a new user", description = "Creates a new user account")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registered successfully",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "409", description = "User already exists")
    })
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody(description = "User details for registration", required = true)
            @org.springframework.web.bind.annotation.RequestBody UserDtO userDtO) {
        authService.register(userDtO);
        return new ResponseEntity<>("User registered successfully", HttpStatus.CREATED);
    }

    @Operation(summary = "Authenticate user", description = "Authenticates a user and returns a token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully authenticated",
                    content = @Content(schema = @Schema(implementation = String.class))),
            @ApiResponse(responseCode = "401", description = "Invalid credentials")
    })
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDtO> login(
            @RequestBody(description = "User credentials for login", required = true)
            @org.springframework.web.bind.annotation.RequestBody UserDtO userDtO) {
        LoginResponseDtO loginResponse = authService.login(userDtO);
        return ResponseEntity.ok(loginResponse);
    }
}