package com.desafio.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/codigo/{id}")
	public Cliente listaClienteId(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@GetMapping("/nome/{nome}")
	public Cliente listaClienteId(@PathVariable(value="nome") String nome){
		return clienteRepository.findByNome(nome);
	}
	
	@PostMapping("/cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	@DeleteMapping("/cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
		
	}
	
	@DeleteMapping("/cliente/{id}")
	public void deletaCliente(@PathVariable(value="id") long id){
		clienteRepository.deleteById(id);
		
	}
	
}
