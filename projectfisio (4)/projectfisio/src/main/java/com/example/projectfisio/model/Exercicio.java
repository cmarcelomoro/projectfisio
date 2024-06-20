package com.example.projectfisio.model;


import jakarta.persistence.*;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String nome;

    @Column(columnDefinition = "text")
    private String descricao;
}
