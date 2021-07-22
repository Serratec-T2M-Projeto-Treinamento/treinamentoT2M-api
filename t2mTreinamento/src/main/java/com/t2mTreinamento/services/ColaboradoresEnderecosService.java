//package com.t2mTreinamento.services;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.t2mTreinamento.entities.ColaboradoresEnderecos;
//import com.t2mTreinamento.entities.ColaboradoresEnderecosId;
//import com.t2mTreinamento.repositories.ColaboradoresEnderecosRepository;
//
//@Service
//public class ColaboradoresEnderecosService {
//
//	@Autowired
//	public ColaboradoresEnderecosRepository colaboradoresEnderecosRepository;
//
//	public ColaboradoresEnderecos findById(ColaboradoresEnderecosId idColaboradorEndereco) {
//		return colaboradoresEnderecosRepository.findById(idColaboradorEndereco).get();
//	}
//
//	public List<ColaboradoresEnderecos> findAll() {
//		return colaboradoresEnderecosRepository.findAll();
//	}
//
//	public Long Count() {
//		return colaboradoresEnderecosRepository.count();
//	}
//
//	public ColaboradoresEnderecos save(ColaboradoresEnderecos colaboradorEndereco) {
//		ColaboradoresEnderecos novoColaboradorEndereco = colaboradoresEnderecosRepository.save(colaboradorEndereco);
//
//		if (novoColaboradorEndereco != null) {
//			return novoColaboradorEndereco;
//		} else {
//			return null;
//		}
//	}
//
//	public boolean delete(ColaboradoresEnderecosId idColaboradorEndereco) {
//		if (idColaboradorEndereco != null) {
//			colaboradoresEnderecosRepository.deleteById(idColaboradorEndereco);
//			return true;
//		} else {
//			return false;
//		}
//	}
//
//	public ColaboradoresEnderecos update(ColaboradoresEnderecos colaboradorEndereco, ColaboradoresEnderecosId idColaboradorEndereco) {
//		colaboradorEndereco.setIdColaboradoresEnderecos(id);
//		return colaboradoresEnderecosRepository.save(colaboradorEndereco);
//	}
//}
