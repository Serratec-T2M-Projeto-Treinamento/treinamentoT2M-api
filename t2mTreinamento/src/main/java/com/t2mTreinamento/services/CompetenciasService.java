package com.t2mTreinamento.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.PosicoesCompetenciasId;
import com.t2mTreinamento.repositories.CompetenciasConhecimentosRepository;
import com.t2mTreinamento.repositories.CompetenciasNiveisRepository;
import com.t2mTreinamento.repositories.CompetenciasRepository;
import com.t2mTreinamento.repositories.ConhecimentosRepository;
import com.t2mTreinamento.repositories.NiveisRepository;
import com.t2mTreinamento.repositories.PosicoesCompetenciasRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class CompetenciasService {

	@Autowired
	public CompetenciasRepository competenciasRepository;

	@Autowired
	PosicoesRepository posicoesRepository;

	@Autowired
	ConhecimentosRepository conhecimentosRepository;

	@Autowired
	NiveisRepository niveisRepository;

	// ADD REPOSITÓRIO EM POSICOES
	@Autowired
	PosicoesCompetenciasRepository posCompsRepository;

	@Autowired
	CompetenciasNiveisRepository compsNvsRepository;

	@Autowired
	CompetenciasConhecimentosRepository compsConhsRepository;

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

	public Competencias inserePosicao(Long idPos, Long idComp) {
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

		PosicoesCompetenciasId posCompsId = new PosicoesCompetenciasId(idPos, idComp);

		PosicoesCompetencias posComp = new PosicoesCompetencias(posCompsId, posicao, competencia, 1);

		Set<PosicoesCompetencias> novoSetPosComps = competencia.getSetPosicoesCompetencias();

		if (novoSetPosComps.add(posComp)) {

			novoSetPosComps.add(posComp);
			competencia.setSetPosicoesCompetencias(novoSetPosComps);
			Competencias competenciaAtualizada = competenciasRepository.save(competencia);

			return competenciaAtualizada;
		} else {
			return null;
		}
	}

	public Competencias removePosicao(Long idPos, Long idComp) {

		if (idPos != null && idComp != null) {
			Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

			PosicoesCompetencias posComp = posCompsRepository.findByPosicaoAndCompetencia(posicao, competencia);

			competencia.getSetPosicoesCompetencias().remove(posComp);

			posCompsRepository.delete(posComp);

			return competencia;
		} else {
			return null;
		}
	}
}
