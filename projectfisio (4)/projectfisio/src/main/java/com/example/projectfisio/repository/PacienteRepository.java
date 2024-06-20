package com.example.projectfisio.repository;

import com.example.projectfisio.model.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PacienteRepository extends CrudRepository<Paciente,Integer> {
}
