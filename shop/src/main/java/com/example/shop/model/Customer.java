package com.example.shop.model;

import jakarta.persistence.*;
import jakarta.validation.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String customerSurname;
    private String password;
    private String username;
    private Long phoneNumber;
}