package com.desafio.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Optional<List<Cliente>> findByNome(String nome);

}
