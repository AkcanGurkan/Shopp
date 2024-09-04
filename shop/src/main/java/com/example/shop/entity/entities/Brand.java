package com.example.shop.entity.entities;


import com.example.shop.entity.entities.productEntities.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@Table(name="BRANDS")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Brand {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> model;


    @OneToMany(mappedBy = "brand")
    private List<Tv> tv;

    @OneToMany(mappedBy = "brand")
    private List<Phone> phone;

    @OneToMany(mappedBy = "brand")
    private List<Headset> headset;

    @OneToMany(mappedBy = "brand")
    private List<Computer> computer;

    @OneToMany(mappedBy = "brand")
    private List<Watch> watch;

}
