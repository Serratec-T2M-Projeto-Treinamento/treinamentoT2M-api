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
@Table(name = "competencias")
public class Competencias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idCompetencias;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "competencia")
	private Set<PosicoesCompetencias> setPosicoesCompetencias;

	@OneToMany(mappedBy = "competencia")
	private Set<CompetenciasNiveis> setCompetenciasNiveis;

	@OneToMany(mappedBy = "competencia")
	private Set<CompetenciasConhecimentos> setCompetenciasConhecimentos;

	public Long getIdCompetencias() {
		return idCompetencias;
	}

	public void setIdCompetencias(Long idCompetencias) {
		this.idCompetencias = idCompetencias;
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

	public Set<CompetenciasNiveis> getSetCompetenciasNiveis() {
		return setCompetenciasNiveis;
	}

	public void setSetCompetenciasNiveis(Set<CompetenciasNiveis> setCompetenciasNiveis) {
		this.setCompetenciasNiveis = setCompetenciasNiveis;
	}

	public Set<CompetenciasConhecimentos> getSetCompetenciasConhecimentos() {
		return setCompetenciasConhecimentos;
	}

	public void setSetCompetenciasConhecimentos(Set<CompetenciasConhecimentos> setCompetenciasConhecimentos) {
		this.setCompetenciasConhecimentos = setCompetenciasConhecimentos;
	}

}
