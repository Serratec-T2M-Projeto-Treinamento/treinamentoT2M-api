package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.entities.ColaboradoresFormacoesId;

@Repository
public interface ColaboradoresFormacoesRepository
		extends JpaRepository<ColaboradoresFormacoes, ColaboradoresFormacoesId> {

}
