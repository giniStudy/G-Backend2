package com.backend.gini.controller;

import com.backend.gini.domain.entity.CategoryEntity;
import com.backend.gini.service.CategoryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "카테고리 검색")
    @GetMapping
    public ResponseEntity<List<CategoryEntity>> getCategoryList(){
        List<CategoryEntity> category = categoryService.getCategoryList();
        HttpStatus status = category.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<List<CategoryEntity>>(category, status);
    }

    @ApiOperation(value = "카테고리 추가", notes = "<strong>카테고리 제목(name)</strong>")
    @PostMapping
    public CategoryEntity insertCategory(@RequestBody CategoryEntity categoryEntity){
        return categoryService.insertCategory(categoryEntity);
    }

    @ApiOperation(value = "카테고리 수정", notes = "<strong>카테고리 제목(name)</strong>")
    @PatchMapping("/{categoryId}")
    public CategoryEntity modifyCategory(@RequestBody CategoryEntity categoryEntity, @PathVariable Integer categoryId){
        return categoryService.modifyCategory(categoryEntity, categoryId);
    }

    @ApiOperation(value = "카테고리 삭제")
    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId){categoryService.deleteCategory(categoryId);}
}