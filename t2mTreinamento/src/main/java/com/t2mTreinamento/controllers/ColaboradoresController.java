package com.t2mTreinamento.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.services.ColaboradoresEnderecosService;
import com.t2mTreinamento.services.ColaboradoresFormacoesService;
import com.t2mTreinamento.services.ColaboradoresProjetosService;
import com.t2mTreinamento.services.ColaboradoresService;
import com.t2mTreinamento.services.UsuariosService;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradoresController {

	@Autowired
	private ColaboradoresService colaboradoresService;

	@Autowired
	private UsuariosService usuariosService;

	@Autowired
	private ColaboradoresEnderecosService colabsEndrsService;

	@Autowired
	private ColaboradoresFormacoesService colabsFormsService;

	@Autowired
	private ColaboradoresProjetosService colabsProjsService;

	@GetMapping("/history/{id}")
	public ResponseEntity<Colaboradores> findById(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Colaboradores> findByIsAtivoAndIdColaboradores(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findByIsAtivoAndIdColaboradores(id), headers, HttpStatus.OK);
	}

	@GetMapping("/history")
	public ResponseEntity<List<Colaboradores>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Colaboradores>> findByIsAtivo() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(colaboradoresService.findByIsAtivo(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long Count() {
		return colaboradoresService.Count();
	}

	@PostMapping
	public ResponseEntity<Colaboradores> save(@Valid @RequestBody Colaboradores colaborador) {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores novoColaborador = colaboradoresService.save(colaborador);

		if (novoColaborador != null) {

			if (colaborador.getIsLider() == 1) {
				usuariosService.save(usuariosService.criaNovoUsuario(colaborador));
			}

			return new ResponseEntity<>(novoColaborador, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(novoColaborador, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Colaboradores> delete(@PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		boolean removidoDeColaboradores = colaboradoresService.delete(id);
		boolean removidoDeColabsEndrs = colabsEndrsService.deleteByColaborador(id);
		boolean removidoDeColabsForms = colabsFormsService.deleteByColaborador(id);
		boolean removidoDeColabsProjs = colabsProjsService.deleteByColaborador(id);

		if (removidoDeColaboradores && removidoDeColabsEndrs && removidoDeColabsForms && removidoDeColabsProjs) {

			return new ResponseEntity<>(headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Colaboradores> update(@RequestBody Colaboradores colaborador, @PathVariable Long id) {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colaboradoresService.update(colaborador, id);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	// UPDATE DE RELACIONAMENTO DE ENDEREÇOS, FORMAÇÕES, PROJETOS E POSIÇÕES

	@PutMapping("/{idColab}/posicao/{idPos}")
	public ResponseEntity<Colaboradores> inserePosicao(@PathVariable Long idColab, @PathVariable Long idPos) {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colaboradoresService.inserePosicao(idColab, idPos);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idColab}/endereco/{idEndr}")
	public ResponseEntity<Colaboradores> insereEndereco(@PathVariable Long idColab, @PathVariable Long idEndr) {
		HttpHeaders headers = new HttpHeaders();

		Colaboradores colaboradorAtualizado = colaboradoresService.insereEndereco(idColab, idEndr);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idColab}/formacao/{idForm}/dataEntrada/{dataEntradaForm}")
	public ResponseEntity<Colaboradores> insereFormacao(@PathVariable Long idColab, @PathVariable Long idForm,
			@PathVariable String dataEntradaForm) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataForm = sdf.parse(dataEntradaForm);
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.setTime(dataForm);

		Colaboradores colaboradorAtualizado = colaboradoresService.insereFormacao(idColab, idForm, dataEntrada);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/{idColab}/projeto/{idProj}/funcao/{funcao}/dataInicio/{dataInicioProj}")
	public ResponseEntity<Colaboradores> insereProjeto(@PathVariable Long idColab, @PathVariable Long idProj,
			@PathVariable String funcao, @PathVariable String dataInicioProj) throws Exception {
		HttpHeaders headers = new HttpHeaders();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataProj = sdf.parse(dataInicioProj);
		Calendar dataInicio = Calendar.getInstance();
		dataInicio.setTime(dataProj);

		Colaboradores colaboradorAtualizado = colaboradoresService.insereProjeto(idColab, idProj, funcao, dataInicio);

		if (colaboradorAtualizado != null) {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(colaboradorAtualizado, headers, HttpStatus.BAD_REQUEST);
		}
	}

}
