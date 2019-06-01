package br.com.msansone.mybudget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.msansone.mybudget.api.model.Expense;
import org.springframework.stereotype.Repository;


public interface ExpenseRepository extends JpaRepository<Expense,Long>  {

}
