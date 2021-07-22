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
@Table(name = "colaboradores_projetos")
public class ColaboradoresProjetos {

	@EmbeddedId
	private ColaboradoresProjetosId idColaboradoresProjetos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idProjeto")
	@JoinColumn(name = "id_projeto")
	private Projetos projeto;

	@Column(name = "funcao")
	private String funcao;

	@Column(name = "data_inicio")
	private Calendar dataInicio;

	@Column(name = "data_saida")
	private Calendar dataSaida;

	@Column(name = "isativo")
	private Integer isAtivo;

	public ColaboradoresProjetosId getIdColaboradoresProjetos() {
		return idColaboradoresProjetos;
	}

	public void setIdColaboradoresProjetos(ColaboradoresProjetosId idColaboradoresProjetos) {
		this.idColaboradoresProjetos = idColaboradoresProjetos;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Projetos getProjeto() {
		return projeto;
	}

	public void setProjeto(Projetos projeto) {
		this.projeto = projeto;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Calendar dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
