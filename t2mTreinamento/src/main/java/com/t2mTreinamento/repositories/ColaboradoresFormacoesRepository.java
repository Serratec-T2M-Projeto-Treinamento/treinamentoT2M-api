package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.entities.ColaboradoresFormacoesId;
import com.t2mTreinamento.entities.Formacoes;

@Repository
public interface ColaboradoresFormacoesRepository
		extends JpaRepository<ColaboradoresFormacoes, ColaboradoresFormacoesId> {

	List<ColaboradoresFormacoes> findByColaborador(Colaboradores colaborador);

	List<ColaboradoresFormacoes> findByFormacao(Formacoes formacao);

	ColaboradoresFormacoes findByColaboradorAndFormacao(Colaboradores colaborador, Formacoes formacao);
}
