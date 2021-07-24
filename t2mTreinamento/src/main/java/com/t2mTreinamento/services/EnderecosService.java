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

	public Enderecos findByIsAtivoAndIdEnderecos(Long idEnderecos) {
		return enderecosRepository.findByIsAtivoAndIdEnderecos(1, idEnderecos);
	}

	public List<Enderecos> findAll() {
		return enderecosRepository.findAll();
	}

	public List<Enderecos> findByIsAtivo() {
		return enderecosRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return enderecosRepository.count();
	}

	public Enderecos save(Enderecos endereco) {
		endereco.setIsAtivo(1);
		Enderecos novoEndereco = enderecosRepository.save(endereco);
		// SERVIÇO DE ENTIDADE DE LIGAÇÃO (?)
		if (novoEndereco != null) {
			return novoEndereco;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		// DELETAR DA LISTA DE REGISTROS ATIVOS
		if (id != null && enderecosRepository.findById(id).get().getIsAtivo() == 1) {
			Enderecos endereco = enderecosRepository.findByIsAtivoAndIdEnderecos(1, id);
			endereco.setIsAtivo(0);
			enderecosRepository.save(endereco);
			return true;
		} else {
			return false;
		}
	}

	public Enderecos update(Enderecos endereco, Long id) {
		endereco.setIdEnderecos(id);
		endereco.setIsAtivo(1);
		return enderecosRepository.save(endereco);
	}
}
