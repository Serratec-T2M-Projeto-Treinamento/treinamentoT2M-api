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

	public List<Projetos> findAll() {
		return projetosRepository.findAll();
	}
	
	public Long Count() {
		return projetosRepository.count();
	}
	
	public Projetos save(Projetos projeto) {
		Projetos novoProjeto = projetosRepository.save(projeto);
		
		if (novoProjeto != null) {
			return novoProjeto;
		} else {
			return null;
		}
	}
	
	public boolean delete(Long id) {
		if(id != null) {
			projetosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Projetos update(Projetos projeto, Long id) {
		projeto.setIdProjetos(id);
		return projetosRepository.save(projeto);
	}
}
