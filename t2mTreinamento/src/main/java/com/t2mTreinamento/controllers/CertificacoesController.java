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

import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.services.CertificacoesService;

@RestController
@RequestMapping("/certificacoes")
public class CertificacoesController {

	@Autowired
	private CertificacoesService certificacoesService;

	@GetMapping("/{id}")
	public ResponseEntity<Certificacoes> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Certificacoes>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(certificacoesService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return certificacoesService.Count();
	}

}
