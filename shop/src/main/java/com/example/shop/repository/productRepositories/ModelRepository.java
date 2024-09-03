package com.example.shop.repository.productRepositories;


import com.example.shop.entity.entities.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {

}
