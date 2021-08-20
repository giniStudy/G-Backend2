package com.backend.gini.domain.boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findByCategoryAndDeleteFlagFalse(Category category);
}