package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.t2mTreinamento.entities.CompetenciasNiveis;
import com.t2mTreinamento.entities.CompetenciasNiveisId;

public interface CompetenciasNiveisRepository extends JpaRepository<CompetenciasNiveis, CompetenciasNiveisId> {

}
