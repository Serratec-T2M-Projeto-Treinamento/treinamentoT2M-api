package com.t2mTreinamento.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "projetos")
public class Projetos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idProjetos;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "app_gerenciamento")
	private String appGerenciamento;

	@Column(name = "segmento")
	private String segmento;

	@Column(name = "data_entrega_esperada")
	private Calendar dataEntregaEsperada;

	@Column(name = "data_entrega")
	private Calendar dataEntrega;

	@Column(name = "equipe")
	private Long equipe;

	@OneToMany(mappedBy = "projeto")
	private Set<ColaboradoresProjetos> setColaboradoresProjetos;

	public Long getIdProjetos() {
		return idProjetos;
	}

	public void setIdProjetos(Long idProjetos) {
		this.idProjetos = idProjetos;
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

	public String getAppGerenciamento() {
		return appGerenciamento;
	}

	public void setAppGerenciamento(String appGerenciamento) {
		this.appGerenciamento = appGerenciamento;
	}

	public String getSegmento() {
		return segmento;
	}

	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}

	public Calendar getDataEntregaEsperada() {
		return dataEntregaEsperada;
	}

	public void setDataEntregaEsperada(Calendar dataEntregaEsperada) {
		this.dataEntregaEsperada = dataEntregaEsperada;
	}

	public Calendar getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Long getEquipe() {
		return equipe;
	}

	public void setEquipe(Long equipe) {
		this.equipe = equipe;
	}

	public Set<ColaboradoresProjetos> getSetColaboradoresProjetos() {
		return setColaboradoresProjetos;
	}

	public void setSetColaboradoresProjetos(Set<ColaboradoresProjetos> setColaboradoresProjetos) {
		this.setColaboradoresProjetos = setColaboradoresProjetos;
	}

}
