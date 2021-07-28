package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class ColaboradoresService {

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public PosicoesRepository posicoesRepository;

	public Colaboradores findById(Long id) {
		return colaboradoresRepository.findById(id).get();
	}

	public Colaboradores findByIsAtivoAndIdColaboradores(Long idColaboradores) {
		return colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColaboradores);
	}

	public List<Colaboradores> findAll() {
		return colaboradoresRepository.findAll();
	}

	public List<Colaboradores> findByIsAtivo() {
		return colaboradoresRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return colaboradoresRepository.count();
	}

	public Colaboradores save(Colaboradores colaborador) {
		colaborador.setIsAtivo(1);
		Colaboradores novoColaborador = colaboradoresRepository.save(colaborador);
		if (novoColaborador != null) {
			return novoColaborador;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && colaboradoresRepository.findById(id).get().getIsAtivo() == 1) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
			colaborador.setIsAtivo(0);
			colaboradoresRepository.save(colaborador);
			return true;
		} else {
			return false;
		}
	}

	public Colaboradores update(Colaboradores colaborador, Long id) {
		colaborador.setIdColaboradores(id);
		colaborador.setIsAtivo(1);
		return colaboradoresRepository.save(colaborador);
	}

	public Colaboradores inserePosicao(Long idColab, Long idPos) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);

		colaborador.setPosicao(posicao);

		Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

		if (colaboradorAtualizado != null) {
			return colaboradorAtualizado;
		} else {
			return null;
		}
	}
}
