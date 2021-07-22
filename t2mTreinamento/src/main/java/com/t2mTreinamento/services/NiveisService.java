package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Niveis;
import com.t2mTreinamento.repositories.NiveisRepository;

@Service
public class NiveisService {

	@Autowired
	public NiveisRepository niveisRepository;

	public Niveis findById(Long id) {
		return niveisRepository.findById(id).get();
	}

	public List<Niveis> findAll() {
		return niveisRepository.findAll();
	}

	public Long Count() {
		return niveisRepository.count();
	}

	public Niveis save(Niveis nivel) {
		Niveis novoNivel = niveisRepository.save(nivel);

		if (novoNivel != null) {
			return novoNivel;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			niveisRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Niveis update(Niveis nivel, Long id) {
		nivel.setIdNiveis(id);
		return niveisRepository.save(nivel);
	}
}
