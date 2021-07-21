package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.ConhecimentosTreinamentos;
import com.t2mTreinamento.entities.ConhecimentosTreinamentosId;

@Repository
public interface ConhecimentosTreinamentosRepository
		extends JpaRepository<ConhecimentosTreinamentos, ConhecimentosTreinamentosId> {

}
