package com.t2mTreinamento.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "competencias_conhecimentos")
public class CompetenciasConhecimentos {

	@EmbeddedId
	private CompetenciasConhecimentosId idCompetenciasConhecimentos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCompetencia")
	private Competencias competencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idConhecimento")
	private Conhecimentos conhecimento;

	public CompetenciasConhecimentosId getIdCompetenciasConhecimentos() {
		return idCompetenciasConhecimentos;
	}

	public void setIdCompetenciasConhecimentos(CompetenciasConhecimentosId idCompetenciasConhecimentos) {
		this.idCompetenciasConhecimentos = idCompetenciasConhecimentos;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	public Conhecimentos getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimentos conhecimento) {
		this.conhecimento = conhecimento;
	}

}
