package com.example.shop.repository.productRepositories;


import com.example.shop.entity.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository  extends JpaRepository<Brand,Integer> {
}
