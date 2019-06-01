package br.com.msansone.mybudget.api.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
}
