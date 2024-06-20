package com.example.projectfisio.controller;


import com.example.projectfisio.model.Evolucao;
import com.example.projectfisio.model.Paciente;
import com.example.projectfisio.repository.EvolucaoRepository;
import com.example.projectfisio.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public Paciente salvarPaciente(Paciente paciente){


        return pacienteRepository.save(paciente);
    }


    public Paciente buscarPaciente(Long id){

         Paciente paciente = pacienteRepository.findById(Math.toIntExact(id)).orElse(null);

        return paciente;
    }

    public void atualizarPaciente(Long id, Paciente pacienteAtualizado) {
        // Verifica se o paciente existe antes de atualizar
        pacienteRepository.findById(Math.toIntExact(id)).ifPresent(paciente -> {
            paciente.setNome(pacienteAtualizado.getNome());
            paciente.setSexo(pacienteAtualizado.getSexo());
            paciente.setDataNasc(pacienteAtualizado.getDataNasc());
            paciente.setEtnia(pacienteAtualizado.getEtnia());
            paciente.setProfissao(pacienteAtualizado.getProfissao());
            paciente.setEstadoCivil(pacienteAtualizado.getEstadoCivil());
            paciente.setNaturalidade(pacienteAtualizado.getNaturalidade());
            paciente.setTelefone(pacienteAtualizado.getTelefone());
            paciente.setEndereco(pacienteAtualizado.getEndereco());
            paciente.setBairro(pacienteAtualizado.getBairro());
            paciente.setMedico(pacienteAtualizado.getMedico());
            paciente.setCartaoSus(pacienteAtualizado.getCartaoSus());
            paciente.setIdade(calcularIdade(pacienteAtualizado.getDataNasc()));

            pacienteRepository.save(paciente);
        });
    }

    public int calcularIdade(LocalDate dataNasc){

        if (dataNasc == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }

        LocalDate hoje = LocalDate.now();
        Period periodo = Period.between(dataNasc, hoje);

        int idade = periodo.getYears();

        return idade;
    }





}
