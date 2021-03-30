package com.backend.gini.controller;

import com.backend.gini.domain.entity.CategoryEntity;
import com.backend.gini.service.CategoryService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.experimental.PackagePrivate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    private final Logger log = LoggerFactory.getLogger(CategoryController.class);

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getCategoryList(){
        List<CategoryEntity> category = categoryService.getCategoryList();
        HttpStatus status = category.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<List<CategoryEntity>>(category, status);
    }

    @PostMapping
    public CategoryEntity insertCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.insertCategory(categoryEntity);
    }

    @PatchMapping("/{categoryId}")
    public CategoryEntity modifyCategory(@RequestBody CategoryEntity categoryEntity, @PathVariable Integer categoryId){
        return categoryService.modifyCategory(categoryEntity, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId){categoryService.deleteCategory(categoryId);}
}