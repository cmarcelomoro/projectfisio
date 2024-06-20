package com.example.projectfisio.repository;

import com.example.projectfisio.model.Sessao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface SessaoRepository extends CrudRepository<Sessao,Long> {
}
