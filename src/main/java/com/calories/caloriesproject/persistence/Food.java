package com.calories.caloriesproject.persistence;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="nume")
    private String nume;

    @Column(name="unitateDeMasura")
    private String UnitateDeMasura;

    @Column(name="calorii")
    private int calorii;

}
