package com.backend.gini.domain.repository;
import com.backend.gini.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}