package com.example.projectfisio.model;

import jakarta.persistence.*;

@Entity
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String nome;


}
