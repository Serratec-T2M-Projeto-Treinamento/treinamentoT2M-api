package com.t2mTreinamento.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.t2mTreinamento.entities.Colaboradores;
import com.t2mTreinamento.entities.ColaboradoresEnderecos;
import com.t2mTreinamento.entities.ColaboradoresEnderecosId;
import com.t2mTreinamento.entities.ColaboradoresFormacoes;
import com.t2mTreinamento.entities.ColaboradoresFormacoesId;
import com.t2mTreinamento.entities.ColaboradoresProjetos;
import com.t2mTreinamento.entities.ColaboradoresProjetosId;
import com.t2mTreinamento.entities.Enderecos;
import com.t2mTreinamento.entities.Formacoes;
import com.t2mTreinamento.entities.Posicoes;
import com.t2mTreinamento.entities.Projetos;
import com.t2mTreinamento.repositories.ColaboradoresEnderecosRepository;
import com.t2mTreinamento.repositories.ColaboradoresFormacoesRepository;
import com.t2mTreinamento.repositories.ColaboradoresProjetosRepository;
import com.t2mTreinamento.repositories.ColaboradoresRepository;
import com.t2mTreinamento.repositories.EnderecosRepository;
import com.t2mTreinamento.repositories.FormacoesRepository;
import com.t2mTreinamento.repositories.PosicoesRepository;
import com.t2mTreinamento.repositories.ProjetosRepository;

@Service
public class ColaboradoresService {

	@Autowired
	public ColaboradoresRepository colaboradoresRepository;

	@Autowired
	public PosicoesRepository posicoesRepository;

	@Autowired
	public EnderecosRepository enderecosRepository;

	@Autowired
	public FormacoesRepository formacoesRepository;

	@Autowired
	public ProjetosRepository projetosRepository;

	@Autowired
	public ColaboradoresEnderecosRepository colabsEndrsRepository;

	@Autowired
	public ColaboradoresFormacoesRepository colabsFormsRepository;

	@Autowired
	public ColaboradoresProjetosRepository colabsProjsRepository;

	public Colaboradores findById(Long id) {
		return colaboradoresRepository.findById(id).get();
	}

	public Colaboradores findByIsAtivoAndIdColaboradores(Long idColaboradores) {
		return colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColaboradores);
	}

	public List<Colaboradores> findAll() {
		return colaboradoresRepository.findAll();
	}

	public List<Colaboradores> findByIsAtivo() {
		return colaboradoresRepository.findByIsAtivo(1);
	}

	public Long Count() {
		return colaboradoresRepository.count();
	}

	public Colaboradores save(Colaboradores colaborador) {
		colaborador.setIsAtivo(1);
		Colaboradores novoColaborador = colaboradoresRepository.save(colaborador);
		if (novoColaborador != null) {
			return novoColaborador;
		} else {
			return null;
		}
	}

	public boolean delete(Long id) {
		if (id != null && colaboradoresRepository.findById(id).get().getIsAtivo() == 1) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, id);
			colaborador.setIsAtivo(0);
			colaboradoresRepository.save(colaborador);
			return true;
		} else {
			return false;
		}
	}

	public Colaboradores update(Colaboradores colaborador, Long id) {
		colaborador.setIdColaboradores(id);
		colaborador.setIsAtivo(1);
		return colaboradoresRepository.save(colaborador);
	}

	public Colaboradores inserePosicao(Long idColab, Long idPos) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Posicoes posicao = posicoesRepository.findByIsAtivoAndIdPosicoes(1, idPos);

		colaborador.setPosicao(posicao);

		Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

		if (colaboradorAtualizado != null) {
			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

	public Colaboradores insereEndereco(Long idColab, Long idEndr) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Enderecos endereco = enderecosRepository.findByIsAtivoAndIdEnderecos(1, idEndr);

		ColaboradoresEnderecosId colabsEndrsId = new ColaboradoresEnderecosId(idColab, idEndr);

		ColaboradoresEnderecos colabEndr = new ColaboradoresEnderecos(colabsEndrsId, colaborador, endereco, 1);

		Set<ColaboradoresEnderecos> novoSetColabsEndrs = colaborador.getSetColaboradoresEnderecos();

		if (novoSetColabsEndrs.add(colabEndr)) {

			novoSetColabsEndrs.add(colabEndr);
			colaborador.setSetColaboradoresEnderecos(novoSetColabsEndrs);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

	public Colaboradores insereFormacao(Long idColab, Long idForm, String dataEntradaForm) throws Exception {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Formacoes formacao = formacoesRepository.findByIsAtivoAndIdFormacoes(1, idForm);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dataForm = sdf.parse(dataEntradaForm);
		Calendar dataEntrada = Calendar.getInstance();
		dataEntrada.setTime(dataForm);

		ColaboradoresFormacoesId colabsFormsId = new ColaboradoresFormacoesId(idColab, idForm);

		ColaboradoresFormacoes colabForm = new ColaboradoresFormacoes(colabsFormsId, colaborador, formacao, dataEntrada,
				1);

		Set<ColaboradoresFormacoes> novoSetColabsForms = colaborador.getSetColaboradoresFormacoes();

		if (novoSetColabsForms.add(colabForm)) {

			novoSetColabsForms.add(colabForm);
			colaborador.setSetColaboradoresFormacoes(novoSetColabsForms);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}
	
	public Colaboradores removeFormacao(Long idColab, Long idForm) {
		
		if (idColab != null && idForm != null) {
			Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
			Formacoes formacao = formacoesRepository.findByIsAtivoAndIdFormacoes(1, idForm);
			
			ColaboradoresFormacoes colabForm = colabsFormsRepository.findByColaboradorAndFormacao(colaborador, formacao);
			
			colaborador.getSetColaboradoresFormacoes().remove(colabForm);
			
			colabsFormsRepository.delete(colabForm);
			
			return colaborador;	
		} else {
			return null;
		}
		
	}

	public Colaboradores insereProjeto(Long idColab, Long idProj, String funcao, Calendar dataInicio) {
		Colaboradores colaborador = colaboradoresRepository.findByIsAtivoAndIdColaboradores(1, idColab);
		Projetos projeto = projetosRepository.findByIsAtivoAndIdProjetos(1, idProj);

		ColaboradoresProjetosId colabsProjsId = new ColaboradoresProjetosId(idColab, idProj);

		ColaboradoresProjetos colabProj = new ColaboradoresProjetos(colabsProjsId, colaborador, projeto, funcao,
				dataInicio, 1);

		Set<ColaboradoresProjetos> novoSetColabsProjs = colaborador.getSetColaboradoresProjetos();

		if (novoSetColabsProjs.add(colabProj)) {

			novoSetColabsProjs.add(colabProj);
			colaborador.setSetColaboradoresProjetos(novoSetColabsProjs);
			Colaboradores colaboradorAtualizado = colaboradoresRepository.save(colaborador);

			return colaboradorAtualizado;
		} else {
			return null;
		}
	}

//	
//	
// FUTURAMENTE ATUALIZAR DATA DE SAÍDA DO PROJETO E DE FORMAÇÃO
//	
//	
//	
//	

}
