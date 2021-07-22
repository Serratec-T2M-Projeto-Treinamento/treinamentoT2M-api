package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.repositories.FormacoesRepository;

@Service
public class FormacoesService {

	@Autowired
	public FormacoesRepository formacoesRepository;

	public Formacoes findById(Long id) {
		return formacoesRepository.findById(id).get();
	}

	public List<Formacoes> findAll() {
		return formacoesRepository.findAll();
	}

	public Long Count() {
		return formacoesRepository.count();
	}

	public Formacoes save(Formacoes formacao) {
		Formacoes novaFormacao = formacoesRepository.save(formacao);

		if (novaFormacao != null) {
			return novaFormacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			formacoesRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Formacoes update(Formacoes formacao, Long id) {
		formacao.setIdFormacoes(id);
		return formacoesRepository.save(formacao);
	}
}
