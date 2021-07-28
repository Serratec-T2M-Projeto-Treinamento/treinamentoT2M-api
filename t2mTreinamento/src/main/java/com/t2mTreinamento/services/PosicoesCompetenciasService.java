package com.t2mTreinamento.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.PosicoesCompetenciasId;
import com.t2mTreinamento.repositories.CompetenciasRepository;
import com.t2mTreinamento.repositories.PosicoesCompetenciasRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;

@Service
public class PosicoesCompetenciasService {

	@Autowired
	PosicoesCompetenciasRepository posCompsRepository;

	@Autowired
	PosicoesRepository posicoesRepository;

	@Autowired
	CompetenciasRepository competenciasRepository;

	public Posicoes insereCompetenciaEmPosicao(Long idPos, Long idComp) {
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
		Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

		PosicoesCompetenciasId posCompsId = new PosicoesCompetenciasId(idPos, idComp);

		PosicoesCompetencias posComp = new PosicoesCompetencias(posCompsId, posicao, competencia, 1);

		Set<PosicoesCompetencias> novoSetPosComps = posicao.getSetPosicoesCompetencias();

		if (novoSetPosComps.add(posComp)) {

			novoSetPosComps.add(posComp);
			posicao.setSetPosicoesCompetencias(novoSetPosComps);
			Posicoes posicaoAtualizada = posicoesRepository.save(posicao);

			return posicaoAtualizada;
		} else {
			return null;
		}
	}

	public Posicoes removeCompetenciaDePosicao(Long idPos, Long idComp) {

		if (idPos != null && idComp != null) {
			Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);
			Competencias competencia = competenciasRepository.findByIsAtivoAndIdCompetencias(1, idComp);

			PosicoesCompetencias posComp = posCompsRepository.findByPosicaoAndCompetencia(posicao, competencia);

			posicao.getSetPosicoesCompetencias().remove(posComp);

			posCompsRepository.delete(posComp);

			return posicao;
		} else {
			return null;
		}
	}

}
