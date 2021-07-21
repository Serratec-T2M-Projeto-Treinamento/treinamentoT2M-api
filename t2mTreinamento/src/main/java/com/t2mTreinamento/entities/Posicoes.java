package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "posicoes")
public class Posicoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idPosicoes;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToOne(mappedBy = "posicao")
	private Colaboradores colaborador;

	@OneToMany(mappedBy = "posicao")
	private Set<PosicoesCompetencias> setPosicoesCompetencias;

	public Long getIdPosicoes() {
		return idPosicoes;
	}

	public void setIdPosicoes(Long idPosicoes) {
		this.idPosicoes = idPosicoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Set<PosicoesCompetencias> getSetPosicoesCompetencias() {
		return setPosicoesCompetencias;
	}

	public void setSetPosicoesCompetencias(Set<PosicoesCompetencias> setPosicoesCompetencias) {
		this.setPosicoesCompetencias = setPosicoesCompetencias;
	}

}
