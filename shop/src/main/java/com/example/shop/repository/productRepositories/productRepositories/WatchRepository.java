package com.example.shop.repository.productRepositories.productRepositories;


import com.example.shop.entity.entities.productEntities.Watch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchRepository extends JpaRepository<Watch,Integer> {
}
