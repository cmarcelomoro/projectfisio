package com.example.projectfisio.repository;


import com.example.projectfisio.model.Tratamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository extends CrudRepository<Tratamento,Integer> {
}
