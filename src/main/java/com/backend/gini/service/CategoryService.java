package com.backend.gini.service;

import com.backend.gini.domain.boards.Category;
import com.backend.gini.domain.boards.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategoryList(){
        return categoryRepository.findAll();
    }

    public Category insertCategory(Category categoryEntity){
        return categoryRepository.save(categoryEntity);
    }

    public Category modifyCategory(Category categoryEntity, Integer categoryId){
        Category categoryEntityInDB = categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("categoryId"));
        categoryEntityInDB.setName(categoryEntity.getName());
        return categoryRepository.save(categoryEntityInDB);
    }

    public void deleteCategory(Integer categoryId){
        categoryRepository.deleteById(categoryId);
    }
}