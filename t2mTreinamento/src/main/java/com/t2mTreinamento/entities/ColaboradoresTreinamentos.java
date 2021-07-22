package com.t2mTreinamento.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "colaboradores_treinamentos")
public class ColaboradoresTreinamentos {

	@EmbeddedId
	private ColaboradoresTreinamentosId idColaboradoresTreinamentos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	@JoinColumn(name = "id_colaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idTreinamento")
	@JoinColumn(name = "id_treinamento")
	private Treinamentos treinamento;

	@Column(name = "status")
	private String status;

	public ColaboradoresTreinamentosId getIdColaboradoresTreinamentos() {
		return idColaboradoresTreinamentos;
	}

	public void setIdColaboradoresTreinamentos(ColaboradoresTreinamentosId idColaboradoresTreinamentos) {
		this.idColaboradoresTreinamentos = idColaboradoresTreinamentos;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Treinamentos getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamentos treinamento) {
		this.treinamento = treinamento;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
