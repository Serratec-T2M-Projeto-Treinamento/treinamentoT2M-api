package com.t2mTreinamento.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.ColaboradoresEnderecosId;
import com.t2mTreinamento.entities.Enderecos;

@Repository
public interface ColaboradoresEnderecosRepository
		extends JpaRepository<ColaboradoresEnderecos, ColaboradoresEnderecosId> {

	List<ColaboradoresEnderecos> findByColaborador(Colaboradores colaborador);

	List<ColaboradoresEnderecos> findByEndereco(Enderecos endereco);

	ColaboradoresEnderecos findByColaboradorAndEndereco(Colaboradores colaborador, Enderecos endereco);

}
