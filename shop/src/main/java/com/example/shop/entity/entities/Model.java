package com.example.shop.entity.entities;

import com.example.shop.entity.entities.productEntities.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity

@Table(name="MODELS")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name="NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;


    @OneToMany(mappedBy = "model")
    private List<Tv> tv;

    @OneToMany(mappedBy = "model")
    private List<Phone> phone;

    @OneToMany(mappedBy = "model")
    private List<Headset> headset;

    @OneToMany(mappedBy = "model")
    private List<Computer> computer;

    @OneToMany(mappedBy = "model")
    private List<Watch> watche;


}






















