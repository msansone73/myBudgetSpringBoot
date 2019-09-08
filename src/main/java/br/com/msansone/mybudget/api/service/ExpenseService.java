package br.com.msansone.mybudget.api.service;


import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.msansone.mybudget.api.model.Expense;
import br.com.msansone.mybudget.api.repository.ExpenseRepository;

@Service
public class ExpenseService {
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	public Expense AdicionarDespesa(Expense expense) {
		return expenseRepository.save(expense);
	}

	public Optional<Expense> listar(Long id){
		return expenseRepository.findById(id);
	}


	public List<Expense> listarTudo() {
		return expenseRepository.findAll();
	}

	public Optional<List<Expense>> getByIdUsuario(Long idUsuario) {
		return expenseRepository.findByIdUsuario(idUsuario);
	}

	public Expense Salvar(Expense expense) {
		System.out.println(expense.getName());
		System.out.println(expense.getValue());

		return expenseRepository.save(expense);
	}
}
