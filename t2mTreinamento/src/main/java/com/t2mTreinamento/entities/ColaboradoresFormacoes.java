package com.t2mTreinamento.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "colaboradores_formacoes")
public class ColaboradoresFormacoes {

	@EmbeddedId
	private ColaboradoresFormacoesId idColaboradoresFormacoes;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idFormacao")
	@JoinColumn(name = "id_formacao")
	private Formacoes formacao;

	@Column(name = "data_entrada")
	private Calendar dataEntrada;

	@Column(name = "data_conclusao")
	private Calendar dataConclusao;

	public ColaboradoresFormacoesId getIdColaboradoresFormacoes() {
		return idColaboradoresFormacoes;
	}

	public void setIdColaboradoresFormacoes(ColaboradoresFormacoesId idColaboradoresFormacoes) {
		this.idColaboradoresFormacoes = idColaboradoresFormacoes;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Formacoes getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacoes formacao) {
		this.formacao = formacao;
	}

	public Calendar getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

}
