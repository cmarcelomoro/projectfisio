package com.example.projectfisio.repository;


import com.example.projectfisio.model.Evolucao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvolucaoRepository extends CrudRepository<Evolucao,Long> {

    List<Evolucao> findByPacienteId(Long pacienteId);
}
