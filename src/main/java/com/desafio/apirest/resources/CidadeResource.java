package com.desafio.apirest.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
}
