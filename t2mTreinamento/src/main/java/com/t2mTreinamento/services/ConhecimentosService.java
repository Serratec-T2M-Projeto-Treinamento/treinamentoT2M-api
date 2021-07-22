package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Conhecimentos;
import com.t2mTreinamento.repositories.ConhecimentosRepository;

@Service
public class ConhecimentosService {

	@Autowired
	public ConhecimentosRepository conhecimentosRepository;

	public Conhecimentos findById(Long id) {
		return conhecimentosRepository.findById(id).get();
	}

	public List<Conhecimentos> findAll() {
		return conhecimentosRepository.findAll();
	}

	public Long Count() {
		return conhecimentosRepository.count();
	}

	public Conhecimentos save(Conhecimentos conhecimento) {
		Conhecimentos novoCertificacao = conhecimentosRepository.save(conhecimento);

		if (novoCertificacao != null) {
			return novoCertificacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			conhecimentosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Conhecimentos update(Conhecimentos conhecimento, Long id) {
		conhecimento.setIdConhecimentos(id);
		return conhecimentosRepository.save(conhecimento);
	}
}
