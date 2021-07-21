package com.t2mTreinamento.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
public class Enderecos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idEnderecos;

	@Column(name = "cep")
	private String cep;

	@Column(name = "rua")
	private String Rua;

	@Column(name = "numero")
	private String numero;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@Column(name = "estado")
	private String estado;

	@Column(name = "pais")
	private String pais;

	@OneToMany(mappedBy = "endereco")
	private Set<ColaboradoresEnderecos> setColaboradoresEnderecos;

	public Long getIdEnderecos() {
		return idEnderecos;
	}

	public void setIdEnderecos(Long idEnderecos) {
		this.idEnderecos = idEnderecos;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return Rua;
	}

	public void setRua(String rua) {
		Rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<ColaboradoresEnderecos> getSetColaboradoresEnderecos() {
		return setColaboradoresEnderecos;
	}

	public void setSetColaboradoresEnderecos(Set<ColaboradoresEnderecos> setColaboradoresEnderecos) {
		this.setColaboradoresEnderecos = setColaboradoresEnderecos;
	}

}
