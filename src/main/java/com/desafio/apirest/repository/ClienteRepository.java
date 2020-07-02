package com.desafio.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.apirest.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
