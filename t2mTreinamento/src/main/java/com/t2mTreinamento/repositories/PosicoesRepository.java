package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Posicoes;

@Repository
public interface PosicoesRepository extends JpaRepository<Posicoes, Long> {

	List<Posicoes> findByIsAtivo(Integer isAtivo);

	Posicoes findByIsAtivoAndIdPosicoes(Integer isAtivo, Long idPosicoes);
}
