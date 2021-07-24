package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.repositories.ColaboradoresEnderecosRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.EnderecosRepository;

@Service
public class ColaboradoresEnderecosService {

	@Autowired
	public ColaboradoresEnderecosRepository colabsEndrsRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public EnderecosRepository enderecosRepository;

	public List<ColaboradoresEnderecos> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsEndrsRepository.findByColaborador(colaborador);
	}

//	
//	
//	
//	IMPLEMENTAR MÉTODOS DE COLABORADORES
//	
//	
//	
//	
//	
//	public List<ColaboradoresEnderecos> findByIdColaboradorAtivo(Long id) {
//		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
//		return colabsEndrsRepository.findByColaborador(colaborador);
//	}

	public List<ColaboradoresEnderecos> findByIdEndereco(Long id) {
		Enderecos endereco = enderecosRepository.findById(id).get();
		return colabsEndrsRepository.findByEndereco(endereco);
	}

	public List<ColaboradoresEnderecos> findByIdEnderecoAtivo(Long id) {
		Enderecos endereco = enderecosRepository.findByIsAtivoAndIdEnderecos(1, id);
		return colabsEndrsRepository.findByEndereco(endereco);
	}

	public List<ColaboradoresEnderecos> findAll() {
		return colabsEndrsRepository.findAll();
	}

	public Long Count() {
		return colabsEndrsRepository.count();
	}

	public ColaboradoresEnderecos save(ColaboradoresEnderecos colabEndr, Long idColab, Long idEndr) {
		Colaboradores colaborador = colaboradoresRepository.findById(idColab).get();
		Enderecos endereco = enderecosRepository.findById(idEndr).get();
		colabEndr.setColaborador(colaborador);
		colabEndr.setEndereco(endereco);
		colabEndr.setIsAtivo(1);
		ColaboradoresEnderecos novoColabEndr = colabsEndrsRepository.save(colabEndr);

		if (novoColabEndr != null) {
			return novoColabEndr;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresEnderecos> listColabsEndrs = colabsEndrsRepository.findByColaborador(colaborador);

			for (ColaboradoresEnderecos colabEndr : listColabsEndrs) {
				colabEndr.setIsAtivo(0);
				colabsEndrsRepository.save(colabEndr);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByEndereco(Long id) {
		if (id != null) {
			Enderecos endereco = enderecosRepository.findById(id).get();
			List<ColaboradoresEnderecos> listColabsEndrs = colabsEndrsRepository.findByEndereco(endereco);

			for (ColaboradoresEnderecos colabEndr : listColabsEndrs) {
				colabEndr.setIsAtivo(0);
				colabsEndrsRepository.save(colabEndr);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ColaboradoresEnderecos colabEndr, ColaboradoresEnderecos novoColabEndr) {
		novoColabEndr.setColaborador(colabEndr.getColaborador());
		novoColabEndr.setEndereco(colabEndr.getEndereco());
		novoColabEndr.setIdColaboradoresEnderecos(colabEndr.getIdColaboradoresEnderecos());
		novoColabEndr.setIsAtivo(colabEndr.getIsAtivo());
	}

	public ColaboradoresEnderecos update(ColaboradoresEnderecos colabEndr, Long idColab, Long idEndr) {
		Colaboradores colaborador = colaboradoresRepository.findById(idColab).get();

		Enderecos endereco = enderecosRepository.findById(idEndr).get();

		ColaboradoresEnderecos novoColabEndr = colabsEndrsRepository.findByColaboradorAndEndereco(colaborador,
				endereco);

		updateDados(colabEndr, novoColabEndr);

		return colabsEndrsRepository.save(novoColabEndr);
	}

}
