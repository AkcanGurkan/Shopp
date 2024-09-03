package com.example.shop.repository.productRepositories.productRepositories;


import com.example.shop.entity.entities.productEntities.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer,Integer> {
}
