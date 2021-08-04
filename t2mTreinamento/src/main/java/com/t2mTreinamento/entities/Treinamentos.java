package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "treinamentos")
public class Treinamentos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idTreinamentos;

	@NotBlank
	@Column(name = "nome")
	private String nome;

	@NotBlank
	@Column(name = "instituicao")
	private String instituicao;

	@Column(name = "carga_horaria")
	private Double cargaHoraria;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToMany(mappedBy = "treinamento", cascade = CascadeType.ALL)
	private Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos;

	@OneToMany(mappedBy = "treinamento", cascade = CascadeType.ALL)
	private Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos;

	@OneToOne(mappedBy = "treinamento", cascade = CascadeType.ALL)
	private Certificacoes certificacao;

	public Long getIdTreinamentos() {
		return idTreinamentos;
	}

	public void setIdTreinamentos(Long idTreinamentos) {
		this.idTreinamentos = idTreinamentos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Double getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Double cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<ConhecimentosTreinamentos> getSetConhecimentosTreinamentos() {
		return setConhecimentosTreinamentos;
	}

	public void setSetConhecimentosTreinamentos(Set<ConhecimentosTreinamentos> setConhecimentosTreinamentos) {
		this.setConhecimentosTreinamentos = setConhecimentosTreinamentos;
	}

	public Set<ColaboradoresTreinamentos> getSetColaboradoresTreinamentos() {
		return setColaboradoresTreinamentos;
	}

	public void setSetColaboradoresTreinamentos(Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos) {
		this.setColaboradoresTreinamentos = setColaboradoresTreinamentos;
	}

	public Certificacoes getCertificacao() {
		return certificacao;
	}

	public void setCertificacao(Certificacoes certificacao) {
		this.certificacao = certificacao;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

}
