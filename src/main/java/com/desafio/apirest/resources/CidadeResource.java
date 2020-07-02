package com.desafio.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.apirest.models.Cidade;
import com.desafio.apirest.repository.CidadeRepository;

@RestController
@RequestMapping(value="/cidade")
public class CidadeResource {

	@Autowired
	CidadeRepository cidadeRepository;
	
	@GetMapping("/cidades")
	public List<Cidade> listaCidades(){
		return cidadeRepository.findAll();
	}
	
	@GetMapping("/nome/{nome}")
	public Cidade listaCidadeNome(@PathVariable(value="nome") String nome){
		return cidadeRepository.findByNome(nome);
	}
	
	@GetMapping("/estado/{estado}")
	public Cidade listaCidadeEstado(@PathVariable(value="estado") String estado){
		return cidadeRepository.findByEstado(estado);
	}
	
	@PostMapping("/cidade")
	public Cidade salvaCidade(@RequestBody Cidade cidade) {
		return cidadeRepository.save(cidade);
		
	}
	
}
