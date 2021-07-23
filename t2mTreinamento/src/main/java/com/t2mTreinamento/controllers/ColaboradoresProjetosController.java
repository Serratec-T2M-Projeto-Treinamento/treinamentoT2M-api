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

import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.services.ColaboradoresProjetosService;

@RestController
@RequestMapping("/colabsProjs")
public class ColaboradoresProjetosController {

	@Autowired
	private ColaboradoresProjetosService colabsProjsService;

	@GetMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdColaborador(id), headers, HttpStatus.OK);
	}

	@GetMapping("/projeto/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> findByIdProjeto(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colabsProjsService.findByIdProjeto(id), headers, HttpStatus.OK);
	}

	@DeleteMapping("/projeto/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> deleteByProjeto(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsProjsService.deleteByProjeto(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/colaborador/{id}")
	public ResponseEntity<List<ColaboradoresProjetos>> deleteByColaborador(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean foiRemovido = colabsProjsService.deleteByColaborador(id);

		if (foiRemovido) {
			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

}
