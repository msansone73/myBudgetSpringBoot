package br.com.msansone.mybudget.api.repository;

import br.com.msansone.mybudget.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
}
