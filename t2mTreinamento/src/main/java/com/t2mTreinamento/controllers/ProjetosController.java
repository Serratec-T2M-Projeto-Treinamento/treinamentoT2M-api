package com.t2mTreinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.services.ProjetosService;

@RestController
@RequestMapping("/projetos")
public class ProjetosController {

	@Autowired
	private ProjetosService projetosService;

	@GetMapping("/{id}")
	public ResponseEntity<Projetos> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Projetos>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(projetosService.findAll(), headers, HttpStatus.OK);
	}
	
    @GetMapping("/count")
	public Long Count() {
		return projetosService.Count();
	}

}
