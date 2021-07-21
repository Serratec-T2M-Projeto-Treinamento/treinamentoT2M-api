package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.ConhecimentosNiveis;
import com.t2mTreinamento.entities.ConhecimentosNiveisId;

@Repository
public interface ConhecimentosNiveisRepository extends JpaRepository<ConhecimentosNiveis, ConhecimentosNiveisId> {

}
