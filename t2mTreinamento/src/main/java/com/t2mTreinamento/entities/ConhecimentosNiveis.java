package com.t2mTreinamento.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "conhecimentos_niveis")
public class ConhecimentosNiveis {

	@EmbeddedId
	private ConhecimentosNiveisId idConhecimentosNiveis;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idConhecimento")
	private Conhecimentos conhecimento;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idNivel")
	private Niveis nivel;

	public ConhecimentosNiveisId getIdConhecimentosNiveis() {
		return idConhecimentosNiveis;
	}

	public void setIdConhecimentosNiveis(ConhecimentosNiveisId idConhecimentosNiveis) {
		this.idConhecimentosNiveis = idConhecimentosNiveis;
	}

	public Conhecimentos getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimentos conhecimento) {
		this.conhecimento = conhecimento;
	}

	public Niveis getNivel() {
		return nivel;
	}

	public void setNivel(Niveis nivel) {
		this.nivel = nivel;
	}

}
