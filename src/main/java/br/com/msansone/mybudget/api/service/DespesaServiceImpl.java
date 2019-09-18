package br.com.msansone.mybudget.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.mybudget.api.model.Despesa;
import br.com.msansone.mybudget.api.repository.DespesaRepository;

@Service
public class DespesaServiceImpl implements DespesaService {

	@Autowired
	DespesaRepository despesaRepository;
	
	@Override
	public Despesa inserir(Despesa despesa) {
		return despesaRepository.save(despesa);
	}

	@Override
	public List<Despesa> listarTudo() {
		return despesaRepository.findAll();
	}

	@Override
	public Despesa getDespesaById(Long id) {
		return despesaRepository.findById(id).get();
	}

}
