package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToMany(mappedBy = "posicao")
	@JsonIgnore
	private Set<Colaboradores> setColaboradores;

	@OneToMany(mappedBy = "posicao")
	@JsonIgnore
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

	public Set<PosicoesCompetencias> getSetPosicoesCompetencias() {
		return setPosicoesCompetencias;
	}

	public void setSetPosicoesCompetencias(Set<PosicoesCompetencias> setPosicoesCompetencias) {
		this.setPosicoesCompetencias = setPosicoesCompetencias;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Set<Colaboradores> getSetColaboradores() {
		return setColaboradores;
	}

	public void setSetColaboradores(Set<Colaboradores> setColaboradores) {
		this.setColaboradores = setColaboradores;
	}

}
