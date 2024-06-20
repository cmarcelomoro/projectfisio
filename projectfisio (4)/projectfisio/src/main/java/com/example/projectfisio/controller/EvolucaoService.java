package com.example.projectfisio.controller;


import com.example.projectfisio.model.Evolucao;
import com.example.projectfisio.model.Paciente;
import com.example.projectfisio.repository.EvolucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class EvolucaoService {


    private final EvolucaoRepository evolucaoRepository;
    @Autowired
    public EvolucaoService(EvolucaoRepository evolucaoRepository) {
        this.evolucaoRepository = evolucaoRepository;
    }


    public List<Evolucao> retornaListaEvolucoes(Long pacienteId){

        return evolucaoRepository.findByPacienteId(pacienteId);
    }


    public Evolucao salvarEvolucao(Evolucao evolucao, Paciente paciente){

        evolucao.setPaciente(paciente);

        return evolucaoRepository.save(evolucao);
    }

}
