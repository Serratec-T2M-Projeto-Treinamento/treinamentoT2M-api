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
@Table(name = "colaboradores_certificacoes")
public class ColaboradoresCertificacoes {

	@EmbeddedId
	private ColaboradoresCertificacoesId idColaboradoresCertificacoes;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCertificacao")
	@JoinColumn(name = "id_certificacao")
	private Certificacoes certificacao;

	@Column(name = "data_obtencao")
	private Calendar dataObtencao;

	public ColaboradoresCertificacoesId getIdColaboradoresCertificacoes() {
		return idColaboradoresCertificacoes;
	}

	public void setIdColaboradoresCertificacoes(ColaboradoresCertificacoesId idColaboradoresCertificacoes) {
		this.idColaboradoresCertificacoes = idColaboradoresCertificacoes;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Certificacoes getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Certificacoes certificacao) {
		this.certificacao = certificacao;
	}

	public Calendar getDataObtencao() {
		return dataObtencao;
	}

	public void setDataObtencao(Calendar dataObtencao) {
		this.dataObtencao = dataObtencao;
	}

}
