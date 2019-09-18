package br.com.msansone.mybudget.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msansone.mybudget.api.model.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long>{

}
