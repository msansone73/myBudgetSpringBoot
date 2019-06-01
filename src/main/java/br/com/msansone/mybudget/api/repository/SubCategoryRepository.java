package br.com.msansone.mybudget.api.repository;

import br.com.msansone.mybudget.api.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {
}
