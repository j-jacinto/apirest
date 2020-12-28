package com.desafio.apirest.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apirest.models.Cliente;
import com.desafio.apirest.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping({"/desafio"})
@Api(value="API REST Clientes")
@CrossOrigin(origins="*")
public class ClienteController {
	
	private ClienteRepository repository;
	
	public ClienteController(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
		
	}
		
	@GetMapping("/clientes")
	@ApiOperation(value="Retorna uma Lista de Clientes")
	public List<Cliente> listaClientes(){
		return repository.findAll();
	}
	
	@GetMapping("/clientes/id/{id}")
	@ApiOperation(value="Retorna um Cliente pelo Id")
	public ResponseEntity<Cliente> buscaClienteId(@PathVariable(value="id") long id){
		return repository.findById(id)
			.map(record -> ResponseEntity.ok().body(record))
	        .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/clientes/nome/{nome}")
	@ApiOperation(value="Retorna um Cliente pelo nome")
	public ResponseEntity<List<Cliente>> buscaClienteNome(@PathVariable(value="nome") String nome){
		return repository.findByNome(nome)
				.map(record -> ResponseEntity.ok().body(record))
		        .orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/clientes")
	@ApiOperation(value="Cadastra um Cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return repository.save(cliente);
		
	}
	
	@DeleteMapping("/clientes")
	@ApiOperation(value="Deleta um Cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		repository.delete(cliente);
		
	}
	
	@DeleteMapping("/clientes/{id}")
	@ApiOperation(value="Deleta um Cliente pelo Id")
	public void deletaCliente(@PathVariable(value="id") long id){
		repository.deleteById(id);
		
	}
	

	@PatchMapping(value= "/clientes/{id}")
	@ApiOperation(value="Altera o nome de um Cliente")
	public ResponseEntity<Cliente> update(@PathVariable("id") long id,
                                          @RequestBody Cliente cliente){
	    return repository.findById(id)
	        .map(record -> {
	            record.setNome(cliente.getNome());
	            Cliente updated = repository.save(record);
	            return ResponseEntity.ok().body(updated);
	        }).orElse(ResponseEntity.notFound().build());
		}
		
	
}
