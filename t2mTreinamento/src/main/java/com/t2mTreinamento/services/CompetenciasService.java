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

	public Competencias findByIsAtivoAndIdCompetencias(Long id) {
		return competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
	}

	public List<Competencias> findAll() {
		return competenciasRepository.findAll();
	}

	public List<Competencias> findByIsAtivo() {
		return competenciasRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return competenciasRepository.count();
	}

	public Competencias save(Competencias competencia) {
		competencia.setIsAtivo(1);
		Competencias novaCompetencia = competenciasRepository.save(competencia);

		if (novaCompetencia != null) {
			return novaCompetencia;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && competenciasRepository.findById(id).get().getIsAtivo() == 1) {
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, id);
			competencia.setIsAtivo(0);
			competenciasRepository.save(competencia);
			return true;
		} else {
			return false;
		}
	}

	public Competencias update(Competencias competencia, Long id) {
		competencia.setIdCompetencias(id);
		competencia.setIsAtivo(1);
		return competenciasRepository.save(competencia);
	}

}
