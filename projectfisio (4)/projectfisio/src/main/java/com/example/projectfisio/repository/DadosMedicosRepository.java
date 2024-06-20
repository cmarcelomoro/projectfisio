package com.example.projectfisio.repository;


import com.example.projectfisio.model.DadosMedicos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DadosMedicosRepository extends CrudRepository<DadosMedicos,Integer> {
}
