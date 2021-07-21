package com.t2mTreinamento.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "colaboradores")
public class Colaboradores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idColaboradores;

	@Column(name = "data_nascimento")
	private Calendar dataNascimento;

	@Column(name = "email")
	private String email;

	@Column(name = "conta_bancaria")
	private Double contaBancaria;

	@Column(name = "pix")
	private String pix;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "cnh")
	private String cnh;

	@Column(name = "islider")
	private Integer isLider;

	// TODAS AS FK

	@OneToOne(mappedBy = "colaborador")
	private Usuarios usuario;

	@OneToOne
	@JoinColumn(name = "id_posicao", referencedColumnName = "id")
	private Posicoes posicao;

	@OneToMany(mappedBy = "colaborador")
	private Set<ColaboradoresEnderecos> setColaboradoresEnderecos;

	@OneToMany(mappedBy = "colaborador")
	private Set<ColaboradoresProjetos> setColaboradoresProjetos;

	@OneToMany(mappedBy = "colaborador")
	private Set<ColaboradoresFormacoes> setColaboradoresFormacoes;

}
