package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Certificacoes;
import com.t2mTreinamento.repositories.CertificacoesRepository;

@Service
public class CertificacoesService {

	@Autowired
	public CertificacoesRepository certificacoesRepository;

	public Certificacoes findById(Long id) {
		return certificacoesRepository.findById(id).get();
	}

	public List<Certificacoes> findAll() {
		return certificacoesRepository.findAll();
	}

	public Long Count() {
		return certificacoesRepository.count();
	}

	public Certificacoes save(Certificacoes certificacao) {
		Certificacoes novaCertificacao = certificacoesRepository.save(certificacao);

		if (novaCertificacao != null) {
			return novaCertificacao;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			certificacoesRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Certificacoes update(Certificacoes certificacao, Long id) {
		certificacao.setIdCertificacoes(id);
		return certificacoesRepository.save(certificacao);
	}
}
