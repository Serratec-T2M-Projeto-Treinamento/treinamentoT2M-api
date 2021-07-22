package com.t2mTreinamento.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "conhecimentos_treinamentos")
public class ConhecimentosTreinamentos {

	@EmbeddedId
	private CompetenciasNiveisId idCompetenciasNiveis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idConhecimento")
	@JoinColumn(name = "id_conhecimento")
	private Conhecimentos conhecimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idTreinamento")
	@JoinColumn(name = "id_treinamento")
	private Treinamentos treinamento;

	public CompetenciasNiveisId getIdCompetenciasNiveis() {
		return idCompetenciasNiveis;
	}

	public void setIdCompetenciasNiveis(CompetenciasNiveisId idCompetenciasNiveis) {
		this.idCompetenciasNiveis = idCompetenciasNiveis;
	}

	public Conhecimentos getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimentos conhecimento) {
		this.conhecimento = conhecimento;
	}

	public Treinamentos getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(Treinamentos treinamento) {
		this.treinamento = treinamento;
	}

}
