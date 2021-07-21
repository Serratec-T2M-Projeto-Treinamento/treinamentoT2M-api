package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.CompetenciasConhecimentos;
import com.t2mTreinamento.entities.CompetenciasConhecimentosId;

@Repository
public interface CompetenciasConhecimentosRepository
		extends JpaRepository<CompetenciasConhecimentos, CompetenciasConhecimentosId> {

}
