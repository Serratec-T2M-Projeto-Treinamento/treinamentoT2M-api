package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Usuarios;
import com.t2mTreinamento.repositories.UsuariosRepository;

@Service
public class UsuariosService {

	@Autowired
	public UsuariosRepository usuariosRepository;

	public Usuarios findById(Long id) {
		return usuariosRepository.findById(id).get();
	}

	public List<Usuarios> findAll() {
		return usuariosRepository.findAll();
	}

	public Long Count() {
		return usuariosRepository.count();
	}

	public Usuarios save(Usuarios usuario) {
		Usuarios novoUsuario = usuariosRepository.save(usuario);

		if (novoUsuario != null) {
			return novoUsuario;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null) {
			usuariosRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	public Usuarios update(Usuarios usuario, Long id) {
		usuario.setIdUsuarios(id);
		return usuariosRepository.save(usuario);
	}
}
