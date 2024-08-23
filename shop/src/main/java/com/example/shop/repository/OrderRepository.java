package com.example.shop.repository;

import com.example.shop.entity.Order;
import com.example.shop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<com.example.shop.entity.Order> findByUser(User user);

    @Query("SELECT o FROM Order o WHERE o.product.ownerUsername = :owner_username")
    List<Order> findAllBySellerUsername(@Param("owner_username") String owner_username);
}
