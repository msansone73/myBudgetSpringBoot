package br.com.msansone.mybudget.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import br.com.msansone.mybudget.api.model.Expense;


public interface ExpenseRepository extends JpaRepository<Expense,Long>  {

	Optional<List<Expense>> findByIdUsuario(@Param("idUsuario") Long idUsuario);

}
