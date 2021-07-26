package com.t2mTreinamento.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.entities.ColaboradoresFormacoesId;
import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.repositories.ColaboradoresFormacoesRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.FormacoesRepository;

@Service
public class ColaboradoresFormacoesService {

	@Autowired
	public ColaboradoresFormacoesRepository colabsFormsRepository;

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public FormacoesRepository formacoesRepository;

	public List<ColaboradoresFormacoes> findByIdColaborador(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findById(id).get();
		return colabsFormsRepository.findByColaborador(colaborador);
	}

	public List<ColaboradoresFormacoes> findByIdColaboradorAtivo(Long id) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
		return colabsFormsRepository.findByColaborador(colaborador);
	}

	public List<ColaboradoresFormacoes> findByIdFormacao(Long id) {
		Formacoes formacao = formacoesRepository.findById(id).get();
		return colabsFormsRepository.findByFormacao(formacao);
	}

	public List<ColaboradoresFormacoes> findByIdFormacaoAtivo(Long id) {
		Formacoes formacao = formacoesRepository.findByIsAtivoAndIdFormacoes(1, id);
		return colabsFormsRepository.findByFormacao(formacao);
	}

	public List<ColaboradoresFormacoes> findAll() {
		return colabsFormsRepository.findAll();
	}

	public Long Count() {
		return colabsFormsRepository.count();
	}

	public ColaboradoresFormacoes save(ColaboradoresFormacoes colabForm, Long idColab, Long idForm) {
		Colaboradores colaborador = colaboradoresRepository.findById(idColab).get();
		Formacoes formacao = formacoesRepository.findById(idForm).get();
		colabForm.setColaborador(colaborador);
		colabForm.setFormacao(formacao);
		colabForm.setIsAtivo(1);
		ColaboradoresFormacoes novoColabForm = colabsFormsRepository.save(colabForm);

		if (novoColabForm != null) {
			return novoColabForm;
		} else {
			return null;
		}
	}

	public boolean deleteByColaborador(Long id) {
		if (id != null) {
			Colaboradores colaborador = colaboradoresRepository.findById(id).get();
			List<ColaboradoresFormacoes> listColabsForms = colabsFormsRepository.findByColaborador(colaborador);

			for (ColaboradoresFormacoes colabForm : listColabsForms) {
				colabForm.setIsAtivo(0);
				colabsFormsRepository.save(colabForm);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean deleteByFormacao(Long id) {
		if (id != null) {
			Formacoes formacao = formacoesRepository.findById(id).get();
			List<ColaboradoresFormacoes> listColabsForms = colabsFormsRepository.findByFormacao(formacao);

			for (ColaboradoresFormacoes colabForm : listColabsForms) {
				colabForm.setIsAtivo(0);
				colabsFormsRepository.save(colabForm);
			}

			return true;
		} else {
			return false;
		}
	}

	private void updateDados(ColaboradoresFormacoes colabForm, ColaboradoresFormacoes novoColabForm) {

		novoColabForm.setDataEntrada(colabForm.getDataEntrada());
		novoColabForm.setDataConclusao(colabForm.getDataConclusao());
		novoColabForm.setIsAtivo(1);
	}

	public ColaboradoresFormacoes update(ColaboradoresFormacoes colabForm, Long idColab, Long idForm) {

		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Formacoes formacao = formacoesRepository.findByIsAtivoAndIdFormacoes(1, idForm);

		ColaboradoresFormacoes novoColabForm = new ColaboradoresFormacoes();

		novoColabForm.setColaborador(colaborador);
		novoColabForm.setFormacao(formacao);
		novoColabForm.setIdColaboradoresFormacoes(new ColaboradoresFormacoesId(idColab, idForm));

		updateDados(colabForm, novoColabForm);

		return colabsFormsRepository.save(novoColabForm);
	}

}
