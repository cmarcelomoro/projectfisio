package com.example.projectfisio.model;


import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime horaInicio;

    @Column
    private LocalDateTime horaFim;

    @ManyToOne
    @JoinColumn(name="paciente_id",nullable = false)
    private Paciente paciente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDateTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalDateTime horaFim) {
        this.horaFim = horaFim;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Sessao() {
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
}
