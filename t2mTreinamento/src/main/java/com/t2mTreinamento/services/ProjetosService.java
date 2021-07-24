package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.repositories.ProjetosRepository;

@Service
public class ProjetosService {

	@Autowired
	public ProjetosRepository projetosRepository;

	public Projetos findById(Long id) {
		return projetosRepository.findById(id).get();
	}

	public Projetos findByIsAtivoAndIdProjetos(Long idProjetos) {
		return projetosRepository.findByIsAtivoAndIdProjetos(1, idProjetos);
	}

	public List<Projetos> findAll() {
		return projetosRepository.findAll();
	}

	public List<Projetos> findByIsAtivo() {
		return projetosRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return projetosRepository.count();
	}

	public Projetos save(Projetos projeto) {
		projeto.setIsAtivo(1);
		Projetos novoProjeto = projetosRepository.save(projeto);

		if (novoProjeto != null) {
			return novoProjeto;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			Projetos projeto = projetosRepository.findById(id).get();
			projeto.setIsAtivo(0);
			projetosRepository.save(projeto);
			return true;
		} else {
			return false;
		}
	}

	public Projetos update(Projetos projeto, Long id) {
		projeto.setIdProjetos(id);
		projeto.setIsAtivo(1);
		return projetosRepository.save(projeto);
	}
}
