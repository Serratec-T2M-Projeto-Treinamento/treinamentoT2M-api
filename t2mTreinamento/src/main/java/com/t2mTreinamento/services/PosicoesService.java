package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class PosicoesService {

	@Autowired
	public PosicoesRepository posicoesRepository;

	public Posicoes findById(Long id) {
		return posicoesRepository.findById(id).get();
	}

	public Posicoes findByIsAtivoAndIdPosicoes(Long idPosicoes) {
		return posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPosicoes);
	}

	public List<Posicoes> findAll() {
		return posicoesRepository.findAll();
	}

	public List<Posicoes> findByIsAtivo() {
		return posicoesRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return posicoesRepository.count();
	}

	public Posicoes save(Posicoes posicao) {
		posicao.setIsAtivo(1);
		Posicoes novaPosicao = posicoesRepository.save(posicao);
		if (novaPosicao != null) {
			return novaPosicao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && posicoesRepository.findById(id).get().getIsAtivo() == 1) {
			Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, id);
			posicao.setIsAtivo(0);
			posicoesRepository.save(posicao);
			return true;
		} else {
			return false;
		}
	}

	public Posicoes update(Posicoes posicao, Long id) {
		posicao.setIdPosicoes(id);
		posicao.setIsAtivo(1);
		return posicoesRepository.save(posicao);
	}
}
