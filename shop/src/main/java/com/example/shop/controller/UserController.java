package com.example.shop.controller;

import com.example.shop.dto.UserDtO;
import com.example.shop.entity.User;
import com.example.shop.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@Tag(name = "User Controller API", description = "Operations related to users")
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Get all users.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Showed all users."),
            @ApiResponse(responseCode = "404", description = "Users not found.")
    })
    @GetMapping
    public ResponseEntity<List<UserDtO>> getAllUsers() {
        List<UserDtO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(summary = "Get user by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDtO> getUserById(@PathVariable Long id) {
        UserDtO user = userService.getUserById(id).orElse(null);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Get user by username.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @GetMapping("usn/{username}")
    public ResponseEntity<UserDtO> getUserByUsername(@PathVariable String username) {
        UserDtO user = userService.getUserByUsername(username).orElse(null);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Get user info by token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user."),
            @ApiResponse(responseCode = "404", description = "User not found.")
    })
    @GetMapping("/info")
    public ResponseEntity<UserDtO> getUserInfo(@RequestHeader("Authorization") String authorizationHeader) {
        String token = authorizationHeader.substring(7);
        System.out.println(token);
        UserDtO userDto = userService.getUserInfoFromToken(token);
        return ResponseEntity.ok(userDto);
    }

    @Operation(summary = "Creates a new user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Created a user."),
            @ApiResponse(responseCode = "404", description = "User not created.")
    })
    @PostMapping
    public ResponseEntity<UserDtO> createUser(@RequestBody UserDtO userDtO) {
        UserDtO newUser = userService.saveUser(userDtO);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @Operation(summary = "Updates a user by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated the user."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't update.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody UserDtO userDtO) {
        userService.updateUser(id, userDtO);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
    }

    @Operation(summary = "Delete a user by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the user."),
            @ApiResponse(responseCode = "404", description = "User not found or couldn't delete.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}