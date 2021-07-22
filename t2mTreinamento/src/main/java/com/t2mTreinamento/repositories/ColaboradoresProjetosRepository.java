package com.t2mTreinamento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.ColaboradoresProjetosId;

@Repository
public interface ColaboradoresProjetosRepository extends JpaRepository<ColaboradoresProjetos, ColaboradoresProjetosId> {

	ColaboradoresProjetos findByColaborador(Colaboradores colaborador);
}
