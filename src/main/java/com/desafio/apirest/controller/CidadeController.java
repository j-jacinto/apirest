package com.desafio.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apirest.models.Cidade;
import com.desafio.apirest.repository.CidadeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/desafio")
@Api(value="API REST Cidades")
@CrossOrigin(origins="*")
public class CidadeController {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@GetMapping("/cidades")
	@ApiOperation(value="Retorna uma Lista de Cidades")
	public List<Cidade> listaCidades(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/cidades/{nome}")
	@ApiOperation(value="Retorna uma cidade a partir do nome da cidade")
	public Cidade buscaCidadeNome(@PathVariable(value="nome") String nome){
		return cidadeRepository.findByNome(nome);
	}
	
	@GetMapping("/cidades/{estado}")
	@ApiOperation(value="Retorna um estado a partir do nome do estado")
	public List<Cidade> listaCidadesPorEstado(@PathVariable(value="estado") String estado){
		return cidadeRepository.findAllByEstado(estado);
	}
	
	@PostMapping("/cidades")
	@ApiOperation(value="Cadastra uma cidade")
	public Cidade salvaCidade(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
		
	}
	
}
