package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "formacoes")
public class Formacoes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idFormacoes;

	@Column(name = "nome")
	private String nome;

	@Column(name = "nivel")
	private String nivel;

	@Column(name = "instituicao")
	private String instituicao;

	@Column(name = "isativo")
	@JsonIgnore
	private Integer isAtivo;

	@OneToMany(mappedBy = "formacao", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<ColaboradoresFormacoes> setColaboradoresFormacoes;

	public Long getIdFormacoes() {
		return idFormacoes;
	}

	public void setIdFormacoes(Long idFormacoes) {
		this.idFormacoes = idFormacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Set<ColaboradoresFormacoes> getSetColaboradoresFormacoes() {
		return setColaboradoresFormacoes;
	}

	public void setSetColaboradoresFormacoes(Set<ColaboradoresFormacoes> setColaboradoresFormacoes) {
		this.setColaboradoresFormacoes = setColaboradoresFormacoes;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
