package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.repositories.ColaboradoresProjetosRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;

@Service
public class ColaboradoresService {

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public ColaboradoresProjetosRepository colabProjRepository;

	public Colaboradores findById(Long id) {
		return colaboradoresRepository.findById(id).get();
	}

	public List<Colaboradores> findAll() {
		return colaboradoresRepository.findAll();
	}

	public Long Count() {
		return colaboradoresRepository.count();
	}

	public Colaboradores save(Colaboradores colaborador) {
		Colaboradores novoColaborador = colaboradoresRepository.save(colaborador);

		if (novoColaborador != null) {
			return novoColaborador;
		} else {
			return null;
		}
	}

	// inativa os dados no banco
	public boolean delete(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			colaborador.setIsAtivo(0);
//			colabProjRepository.findByColaborador(colaborador).setIsAtivo(0);
			return true;
		} else {
			return false;
		}
	}

	public Colaboradores update(Colaboradores colaborador, Long id) {
		colaborador.setIdColaboradores(id);
		return colaboradoresRepository.save(colaborador);
	}
}
