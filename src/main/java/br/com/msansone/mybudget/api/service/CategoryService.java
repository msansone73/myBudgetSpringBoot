package br.com.msansone.mybudget.api.service;

import br.com.msansone.mybudget.api.model.Category;
import br.com.msansone.mybudget.api.model.SubCategory;
import br.com.msansone.mybudget.api.repository.CategoryRepository;
import br.com.msansone.mybudget.api.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    SubCategoryRepository subCategoryRepository;

    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public SubCategory addSubCategory(SubCategory subCategory){
        return subCategoryRepository.save(subCategory);
    }
}
