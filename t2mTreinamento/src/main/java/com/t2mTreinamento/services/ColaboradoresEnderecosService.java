package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.ColaboradoresEnderecosId;
import com.t2mTreinamento.repositories.ColaboradoresEnderecosRepository;

@Service
public class ColaboradoresEnderecosService {

	@Autowired
	public ColaboradoresEnderecosRepository colabsEndsRepository;

	public ColaboradoresEnderecos findById(ColaboradoresEnderecosId idColaboradorEndereco) {
		return colabsEndsRepository.findById(idColaboradorEndereco).get();
	}

	public List<ColaboradoresEnderecos> findAll() {
		return colabsEndsRepository.findAll();
	}

	public Long Count() {
		return colabsEndsRepository.count();
	}

	public ColaboradoresEnderecos save(ColaboradoresEnderecos colaboradorEndereco) {
		ColaboradoresEnderecos novoColaboradorEndereco = colabsEndsRepository.save(colaboradorEndereco);

		if (novoColaboradorEndereco != null) {
			return novoColaboradorEndereco;
		} else {
			return null;
		}
	}

	public boolean delete(ColaboradoresEnderecosId idColaboradorEndereco) {
		if (idColaboradorEndereco != null) {
			colabsEndsRepository.deleteById(idColaboradorEndereco);
			return true;
		} else {
			return false;
		}
	}

	public ColaboradoresEnderecos update(ColaboradoresEnderecos colaboradorEndereco,
			ColaboradoresEnderecosId idColaboradorEndereco) {
		colaboradorEndereco.setIdColaboradoresEnderecos(idColaboradorEndereco);
		return colabsEndsRepository.save(colaboradorEndereco);
	}
}
