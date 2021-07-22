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

	public List<Posicoes> findAll() {
		return posicoesRepository.findAll();
	}

	public Long Count() {
		return posicoesRepository.count();
	}

	public Posicoes save(Posicoes posicao) {
		Posicoes novaPosicao = posicoesRepository.save(posicao);

		if (novaPosicao != null) {
			return novaPosicao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			posicoesRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Posicoes update(Posicoes posicao, Long id) {
		posicao.setIdPosicoes(id);
		return posicoesRepository.save(posicao);
	}
}
