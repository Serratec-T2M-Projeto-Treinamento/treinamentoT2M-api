package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.repositories.CompetenciasRepository;

@Service
public class CompetenciasService {

	@Autowired
	public CompetenciasRepository competenciasRepository;

	public Competencias findById(Long id) {
		return competenciasRepository.findById(id).get();
	}

	public List<Competencias> findAll() {
		return competenciasRepository.findAll();
	}

	public Long Count() {
		return competenciasRepository.count();
	}

	public Competencias save(Competencias competencia) {
		Competencias novaCertificacao = competenciasRepository.save(competencia);

		if (novaCertificacao != null) {
			return novaCertificacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			competenciasRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Competencias update(Competencias competencia, Long id) {
		competencia.setIdCompetencias(id);
		return competenciasRepository.save(competencia);
	}
}
