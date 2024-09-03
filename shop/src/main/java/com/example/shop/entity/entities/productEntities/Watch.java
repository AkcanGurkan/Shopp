package com.example.shop.entity.entities.productEntities;

import com.example.shop.entity.entities.Brand;
import com.example.shop.entity.entities.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity

@Table(name="Saat")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Watch {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME" , nullable = false)
    private String name = "Saat";

    @ManyToOne
    @JoinColumn(name="Model_id")
    private Model model;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;


    @Column(name = "İNÇ")
    private Double inc;

    @Column(name = "GB")
    private Double GB;

    @Column(name = "RAM")
    private Double RAM;

    @Column(name = "Batarya Ömrü")
    private Double mAH;

    @Column(name = "Hat sayısı")
    private String hatsayisi;

    @Column(name = "5G")
    private String besG;

    @Column(name = "Renk")
    private String colour;

    @Column(name = "Fiyat")
    private BigDecimal price;
}
