package com.example.projectfisio.repository;


import com.example.projectfisio.model.Exercicio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExercicioRepository extends CrudRepository<Exercicio,Integer> {
}
