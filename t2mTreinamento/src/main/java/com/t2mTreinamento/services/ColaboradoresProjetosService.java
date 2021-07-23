package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.repositories.ColaboradoresProjetosRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.ProjetosRepository;

@Service
public class ColaboradoresProjetosService {

	@Autowired
	public ColaboradoresProjetosRepository colabsProjsRepository;

	@Autowired
	public ProjetosRepository projetosRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	public List<ColaboradoresProjetos> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsProjsRepository.findByColaborador(colaborador);

	}

	public List<ColaboradoresProjetos> findByIdProjeto(Long id) {
		Projetos projeto = projetosRepository.findById(id).get();
		return colabsProjsRepository.findByProjeto(projeto);
	}

	public List<ColaboradoresProjetos> findAll() {
		return colabsProjsRepository.findAll();
	}

	public Long Count() {
		return colabsProjsRepository.count();
	}

	public ColaboradoresProjetos save(ColaboradoresProjetos colabProj, Long idColab, Long idProj) {
		Colaboradores colaborador = colaboradoresRepository.findById(idColab).get();
		Projetos projeto = projetosRepository.findById(idProj).get();
		colabProj.setColaborador(colaborador);
		colabProj.setProjeto(projeto);
		colabProj.setIsAtivo(1);
		ColaboradoresProjetos novoColabProj = colabsProjsRepository.save(colabProj);

		if (novoColabProj != null) {
			return novoColabProj;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresProjetos> listColabsProjs = colabsProjsRepository.findByColaborador(colaborador);

			for (ColaboradoresProjetos colabProj : listColabsProjs) {
				colabProj.setIsAtivo(0);
				colabsProjsRepository.save(colabProj);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByProjeto(Long id) {
		if (id != null) {
			Projetos projeto = projetosRepository.findById(id).get();
			List<ColaboradoresProjetos> listColabsProjs = colabsProjsRepository.findByProjeto(projeto);

			for (ColaboradoresProjetos colabProj : listColabsProjs) {
				colabProj.setIsAtivo(0);
				colabsProjsRepository.save(colabProj);
			}

			return true;
		} else {
			return false;
		}
	}

//	public ColaboradoresProjetos update(Projetos projeto, Long id) {
//		projeto.setIdProjetos(id);
//		projeto.setIsAtivo(1);
//		return colabsProjsRepository.save(projeto);
//	}
}
