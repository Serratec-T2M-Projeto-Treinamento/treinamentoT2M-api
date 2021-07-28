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

	public Conhecimentos findByIsAtivoAndIdConhecimentos(Long idConhecimentos) {
		return conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, idConhecimentos);
	}

	public List<Conhecimentos> findAll() {
		return conhecimentosRepository.findAll();
	}

	public List<Conhecimentos> findByIsAtivo() {
		return conhecimentosRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return conhecimentosRepository.count();
	}

	public Conhecimentos save(Conhecimentos conhecimento) {
		conhecimento.setIsAtivo(1);
		Conhecimentos novoConhecimento = conhecimentosRepository.save(conhecimento);

		if (novoConhecimento != null) {
			return novoConhecimento;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && conhecimentosRepository.findById(id).get().getIsAtivo() == 1) {
			Conhecimentos conhecimento = conhecimentosRepository.findByIsAtivoAndIdConhecimentos(1, id);
			conhecimento.setIsAtivo(0);
			conhecimentosRepository.save(conhecimento);

			return true;
		} else {
			return false;
		}
	}

	public Conhecimentos update(Conhecimentos conhecimento, Long id) {
		conhecimento.setIdConhecimentos(id);
		conhecimento.setIsAtivo(1);
		return conhecimentosRepository.save(conhecimento);
	}
}
