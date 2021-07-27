package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2mTreinamento.entities.Competencias;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.PosicoesCompetencias;
import com.t2mTreinamento.entities.PosicoesCompetenciasId;

public interface PosicoesCompetenciasRepository extends JpaRepository<PosicoesCompetencias, PosicoesCompetenciasId> {

	PosicoesCompetencias findByPosicaoAndCompetencia(Posicoes posicao, Competencias competencia);

}
