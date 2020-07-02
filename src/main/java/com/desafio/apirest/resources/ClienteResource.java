package com.desafio.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apirest.models.Cliente;
import com.desafio.apirest.repository.ClienteRepository;

@RestController
@RequestMapping(value="/cliente")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
}