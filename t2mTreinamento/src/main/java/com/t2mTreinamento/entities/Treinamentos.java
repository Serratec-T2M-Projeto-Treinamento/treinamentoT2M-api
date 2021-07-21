package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "treinamentos")
public class Treinamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private String idTreinamentos;

	@Column(name = "nome")
	private String nome;

	@Column(name = "instituicao")
	private String instituicao;

	@Column(name = "carga_horaria")
	private Double cargaHoraria;

	@Column(name = "descricao")
	private String descricao;

	// TODAS AS FK
	@OneToMany(mappedBy = "treinamento")
	private Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos;
}
