package com.t2mTreinamento.services;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.Usuarios;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	public UsuariosRepository usuariosRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	public Usuarios findById(Long id) {
		return usuariosRepository.findById(id).get();
	}

	public Usuarios findByIsAtivoAndIdUsuarios(Long idUsuarios) {
		return usuariosRepository.findByIsAtivoAndIdUsuarios(1, idUsuarios);
	}

	public List<Usuarios> findAll() {
		return usuariosRepository.findAll();
	}

	public List<Usuarios> findByIsAtivo() {
		return usuariosRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return usuariosRepository.count();
	}

	public Usuarios criaNovoUsuario(Colaboradores colaborador) {

		String nomeUsuario = colaborador.getCpf().charAt(0) + "-" + colaborador.getCpf().charAt(4)
				+ colaborador.getCpf().charAt(8) + colaborador.getCpf().charAt(12) + colaborador.getCpf().charAt(13);

		String senha = colaborador.getDataNascimento().get(Calendar.YEAR) + "/"
				+ colaborador.getDataNascimento().get(Calendar.MONTH);

		Usuarios novoUsuario = new Usuarios(nomeUsuario, senha, 1, colaborador);

		return novoUsuario;

	}

	public Usuarios save(Usuarios novoUsuario) {

		Usuarios usuario = usuariosRepository.save(novoUsuario);

		if (usuario != null) {
			return usuario;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		// DELETAR DA LISTA DE REGISTROS ATIVOS
		if (id != null && usuariosRepository.findById(id).get().getIsAtivo() == 1) {
			Usuarios usuario = usuariosRepository.findByIsAtivoAndIdUsuarios(1, id);
			usuario.setIsAtivo(0);
			usuariosRepository.save(usuario);
			return true;
		} else {
			return false;
		}
	}

	public Usuarios update(Usuarios usuario, Long id) {
		usuario.setIdUsuarios(id);
		usuario.setIsAtivo(1);
		return usuariosRepository.save(usuario);
	}

	public Usuarios insereColaborador(Long idUsuario, Long idColab) {
		Usuarios usuario = usuariosRepository.findByIsAtivoAndIdUsuarios(1, idUsuario);
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);

		if (colaborador.getIsLider() == 1) {
			usuario.setColaborador(colaborador);

			Usuarios usuarioAtualizado = usuariosRepository.save(usuario);

			if (usuarioAtualizado != null) {
				return usuarioAtualizado;
			} else {
				return null;
			}

		} else {
			return null;
		}
	}

	public boolean verificaAdmin(Long idUsuario) {
		Usuarios usuario = usuariosRepository.findByIsAtivoAndIdUsuarios(1, idUsuario);

		if (usuario.getIsAdmin() == 1) {
			return true;
		} else {
			return false;
		}
	}
}
