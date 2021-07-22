package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Treinamentos;
import com.t2mTreinamento.repositories.TreinamentosRepository;

@Service
public class TreinamentosService {

	@Autowired
	public TreinamentosRepository treinamentosRepository;

	public Treinamentos findById(Long id) {
		return treinamentosRepository.findById(id).get();
	}

	public List<Treinamentos> findAll() {
		return treinamentosRepository.findAll();
	}

	public Long Count() {
		return treinamentosRepository.count();
	}

	public Treinamentos save(Treinamentos treinamento) {
		Treinamentos novoTreinamento = treinamentosRepository.save(treinamento);

		if (novoTreinamento != null) {
			return novoTreinamento;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			treinamentosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Treinamentos update(Treinamentos treinamento, Long id) {
		treinamento.setIdTreinamentos(id);
		return treinamentosRepository.save(treinamento);
	}
}
