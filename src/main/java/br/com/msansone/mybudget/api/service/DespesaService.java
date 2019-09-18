package br.com.msansone.mybudget.api.service;

import java.util.List;

import br.com.msansone.mybudget.api.model.Despesa;

public interface DespesaService {

	Despesa inserir(Despesa despesa);
	List<Despesa> listarTudo();	
	Despesa getDespesaById(Long id);
	
}
