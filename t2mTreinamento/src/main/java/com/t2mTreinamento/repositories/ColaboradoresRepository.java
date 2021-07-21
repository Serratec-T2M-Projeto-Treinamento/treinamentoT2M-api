package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;

@Repository
public interface ColaboradoresRepository extends JpaRepository<Colaboradores, Long> {

}
