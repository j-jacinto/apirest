package com.desafio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apirest.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

}
