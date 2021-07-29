package com.t2mTreinamento.entities;

import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "colaboradores")
public class Colaboradores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long idColaboradores;

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_nascimento")
	private Calendar dataNascimento;

	@Column(name = "email")
	private String email;

	@Column(name = "pix")
	private String pix;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "rg")
	private String rg;

	@Column(name = "cnh")
	private String cnh;

	@Column(name = "permissao")
	private Integer permissao;

	@Column(name = "isativo")
	private Integer isAtivo;

	@OneToOne(mappedBy = "colaborador", cascade = CascadeType.ALL)
	private Usuarios usuario;

	@ManyToOne
	@JoinColumn(name = "id_posicao", referencedColumnName = "id")
	private Posicoes posicao;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColaboradoresEnderecos> setColaboradoresEnderecos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColaboradoresProjetos> setColaboradoresProjetos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColaboradoresFormacoes> setColaboradoresFormacoes;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos;

	@OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes;

	public Colaboradores() {

	}

	public Colaboradores(String nome, Calendar dataNascimento, String email, Double contaBancaria, String pix,
			String cpf, String rg, String cnh, Integer permissao) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.pix = pix;
		this.cpf = cpf;
		this.rg = rg;
		this.cnh = cnh;
		this.permissao = permissao;
	}

	public Long getIdColaboradores() {
		return idColaboradores;
	}

	public void setIdColaboradores(Long idColaboradores) {
		this.idColaboradores = idColaboradores;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Posicoes getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicoes posicao) {
		this.posicao = posicao;
	}

	public Set<ColaboradoresEnderecos> getSetColaboradoresEnderecos() {
		return setColaboradoresEnderecos;
	}

	public void setSetColaboradoresEnderecos(Set<ColaboradoresEnderecos> setColaboradoresEnderecos) {
		this.setColaboradoresEnderecos = setColaboradoresEnderecos;
	}

	public Set<ColaboradoresProjetos> getSetColaboradoresProjetos() {
		return setColaboradoresProjetos;
	}

	public void setSetColaboradoresProjetos(Set<ColaboradoresProjetos> setColaboradoresProjetos) {
		this.setColaboradoresProjetos = setColaboradoresProjetos;
	}

	public Set<ColaboradoresFormacoes> getSetColaboradoresFormacoes() {
		return setColaboradoresFormacoes;
	}

	public void setSetColaboradoresFormacoes(Set<ColaboradoresFormacoes> setColaboradoresFormacoes) {
		this.setColaboradoresFormacoes = setColaboradoresFormacoes;
	}

	public Set<ColaboradoresTreinamentos> getSetColaboradoresTreinamentos() {
		return setColaboradoresTreinamentos;
	}

	public void setSetColaboradoresTreinamentos(Set<ColaboradoresTreinamentos> setColaboradoresTreinamentos) {
		this.setColaboradoresTreinamentos = setColaboradoresTreinamentos;
	}

	public Set<ColaboradoresCertificacoes> getSetColaboradoresCertificacoes() {
		return setColaboradoresCertificacoes;
	}

	public void setSetColaboradoresCertificacoes(Set<ColaboradoresCertificacoes> setColaboradoresCertificacoes) {
		this.setColaboradoresCertificacoes = setColaboradoresCertificacoes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(Integer isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Integer getPermissao() {
		return permissao;
	}

	public void setPermissao(Integer permissao) {
		this.permissao = permissao;
	}

}
