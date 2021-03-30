package com.backend.gini.service;

import com.backend.gini.domain.entity.CategoryEntity;
import com.backend.gini.domain.repository.CategoryRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> getCategoryList(){
        return categoryRepository.findAll();
    }

    public CategoryEntity insertCategory(CategoryEntity categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    public CategoryEntity modifyCategory(CategoryEntity categoryEntity, Integer categoryId){
        CategoryEntity categoryEntityInDB = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("categoryId"));
        categoryEntityInDB.setName(categoryEntity.getName());
        return categoryRepository.save(categoryEntityInDB);
    }

    public void deleteCategory(Integer categoryId){
        categoryRepository.deleteById(categoryId);
    }
}