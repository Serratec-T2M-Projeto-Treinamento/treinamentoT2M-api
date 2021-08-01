package com.t2mTreinamento.dtos;

public class PosicoesDTO {
	private Long idPosicoes;
	private String nome;
	private String descricao;
	// add lista competencias
//	private Set<PosicoesCompetenciasDTO> setPosComps;

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

	public Long getIdPosicoes() {
		return idPosicoes;
	}

	public void setIdPosicoes(Long idPosicoes) {
		this.idPosicoes = idPosicoes;
	}

}
