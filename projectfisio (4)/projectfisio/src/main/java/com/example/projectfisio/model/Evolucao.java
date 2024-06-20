package com.example.projectfisio.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Evolucao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="paciente_id",nullable = false)
    private Paciente paciente;

    @Column(nullable = false,columnDefinition = "text")
    private String descricao;

    /*
    @ManyToOne
    @JoinColumn(name="exercicio")
    private Exercicio exercicio;
    */

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate diaHora;

    @Override
    public String toString() {
        return "Evolucao{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                // Adicione outros atributos conforme necessário
                '}';
    }

    public Evolucao() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDiaHora() {
        return diaHora;
    }

    public void setDiaHora(LocalDate diaHora) {
        this.diaHora = diaHora;
    }
}
