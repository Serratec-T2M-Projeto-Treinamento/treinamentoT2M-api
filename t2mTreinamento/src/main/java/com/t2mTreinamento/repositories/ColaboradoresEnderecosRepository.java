package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.ColaboradoresEnderecosId;

@Repository
public interface ColaboradoresEnderecosRepository
		extends JpaRepository<ColaboradoresEnderecos, ColaboradoresEnderecosId> {
	
}
