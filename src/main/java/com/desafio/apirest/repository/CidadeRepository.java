package com.desafio.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apirest.models.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	Cidade findByNome(String nome);
	Cidade findByEstado(String estado);
	List<Cidade> findAllByEstado(String estado);

}
