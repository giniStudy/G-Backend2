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

}