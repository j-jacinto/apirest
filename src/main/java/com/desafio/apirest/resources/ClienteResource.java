package com.desafio.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apirest.models.Cliente;
import com.desafio.apirest.repository.ClienteRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/desafio")
@Api(value="API REST Clientes")
@CrossOrigin(origins="*")
public class ClienteResource {

	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping("/cliente/lista")
	@ApiOperation(value="Retorna uma Lista de Clientes")
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	@GetMapping("/cliente/id{id}")
	@ApiOperation(value="Retorna um Cliente pelo Id")
	public Cliente buscaClienteId(@PathVariable(value="id") long id){
		return clienteRepository.findById(id);
	}
	
	@GetMapping("/cliente/nome{nome}")
	@ApiOperation(value="Retorna um Cliente pelo nome")
	public Cliente buscaClienteNome(@PathVariable(value="nome") String nome){
		return clienteRepository.findByNome(nome);
	}
	
	@PostMapping("/cliente")
	@ApiOperation(value="Cadastra um Cliente")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
	@DeleteMapping("/cliente")
	@ApiOperation(value="Deleta um Cliente")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
		
	}
	
	@DeleteMapping("/cliente/id{id}")
	@ApiOperation(value="Deleta um Cliente pelo Id")
	public void deletaCliente(@PathVariable(value="id") long id){
		clienteRepository.deleteById(id);
		
	}
	
	@PutMapping("/cliente")
	@ApiOperation(value="Altera um Cliente")
	public Cliente alteraCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
		
	}
	
}
