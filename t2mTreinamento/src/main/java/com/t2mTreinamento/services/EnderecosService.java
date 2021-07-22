package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.repositories.EnderecosRepository;

@Service
public class EnderecosService {

	@Autowired
	public EnderecosRepository enderecosRepository;

	public Enderecos findById(Long id) {
		return enderecosRepository.findById(id).get();
	}

	public List<Enderecos> findAll() {
		return enderecosRepository.findAll();
	}

	public Long Count() {
		return enderecosRepository.count();
	}

	public Enderecos save(Enderecos endereco) {
		Enderecos novoEndereco = enderecosRepository.save(endereco);

		if (novoEndereco != null) {
			return novoEndereco;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			enderecosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Enderecos update(Enderecos endereco, Long id) {
		endereco.setIdEnderecos(id);
		return enderecosRepository.save(endereco);
	}
}
