package com.backend.gini.domain.boards;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public Optional<Category> findByName(String name);
}