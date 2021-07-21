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
@Table(name = "conhecimentos")
public class Conhecimentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idConhecimentos;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(mappedBy = "conhecimento")
	private Set<CompetenciasConhecimentos> setCompetenciasConhecimentos;

	@OneToMany(mappedBy = "conhecimento")
	private Set<ConhecimentosNiveis> setConhecimentosNiveis;

	@OneToMany(mappedBy = "conhecimento")
	private Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos;

	public Long getIdConhecimentos() {
		return idConhecimentos;
	}

	public void setIdConhecimentos(Long idConhecimentos) {
		this.idConhecimentos = idConhecimentos;
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

	public Set<CompetenciasConhecimentos> getSetCompetenciasConhecimentos() {
		return setCompetenciasConhecimentos;
	}

	public void setSetCompetenciasConhecimentos(Set<CompetenciasConhecimentos> setCompetenciasConhecimentos) {
		this.setCompetenciasConhecimentos = setCompetenciasConhecimentos;
	}

	public Set<ConhecimentosNiveis> getSetConhecimentosNiveis() {
		return setConhecimentosNiveis;
	}

	public void setSetConhecimentosNiveis(Set<ConhecimentosNiveis> setConhecimentosNiveis) {
		this.setConhecimentosNiveis = setConhecimentosNiveis;
	}

	public Set<ConhecimentosTreinamentos> getSetConhecimentosTreinamentos() {
		return setConhecimentosTreinamentos;
	}

	public void setSetConhecimentosTreinamentos(Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos) {
		this.setConhecimentosTreinamentos = setConhecimentosTreinamentos;
	}

}
