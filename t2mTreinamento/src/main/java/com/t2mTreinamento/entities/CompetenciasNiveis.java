package com.t2mTreinamento.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "competencias_niveis")
public class CompetenciasNiveis {

	@EmbeddedId
	private CompetenciasNiveisId idCompetenciasNiveis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idCompetencia")
	private Competencias competencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idNivel")
	private Niveis nivel;

	public CompetenciasNiveisId getIdCompetenciasNiveis() {
		return idCompetenciasNiveis;
	}

	public void setIdCompetenciasNiveis(CompetenciasNiveisId idCompetenciasNiveis) {
		this.idCompetenciasNiveis = idCompetenciasNiveis;
	}

	public Competencias getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Competencias competencia) {
		this.competencia = competencia;
	}

	public Niveis getNivel() {
		return nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}

}
