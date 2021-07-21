package com.t2mTreinamento.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "colaboradores_enderecos")
public class ColaboradoresEnderecos {
	@EmbeddedId
	private ColaboradoresEnderecosId idColaboradoresEnderecos;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idColaborador")
	private Colaboradores colaborador;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("idEndereco")
	private Enderecos endereco;

	public ColaboradoresEnderecosId getIdColaboradoresEnderecos() {
		return idColaboradoresEnderecos;
	}

	public void setIdColaboradoresEnderecos(ColaboradoresEnderecosId idColaboradoresEnderecos) {
		this.idColaboradoresEnderecos = idColaboradoresEnderecos;
	}

	public Colaboradores getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaboradores colaborador) {
		this.colaborador = colaborador;
	}

	public Enderecos getEndereco() {
		return endereco;
	}

	public void setEndereco(Enderecos endereco) {
		this.endereco = endereco;
	}

}
