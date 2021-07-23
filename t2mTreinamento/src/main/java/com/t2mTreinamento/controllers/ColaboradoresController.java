package com.t2mTreinamento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.services.ColaboradoresService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {

	@Autowired
	ColaboradoresService colaboradoresService;

	@GetMapping("/{id}")
	public ResponseEntity<Colaboradores> findById(@PathVariable Long id) throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Colaboradores>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return colaboradoresService.Count();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Colaboradores> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colaboradoresService.delete(id);

		if (foiRemovido) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}
