package com.t2mTreinamento.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificacoes")
public class Certificacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idCertificacoes;

	@Column(name = "tempo_validade")
	private Double tempoValidade;

	// TODAS AS FK

}
