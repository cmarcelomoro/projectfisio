package com.example.projectfisio.model;


import jakarta.persistence.*;

@Entity
public class DadosMedicos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;
}
