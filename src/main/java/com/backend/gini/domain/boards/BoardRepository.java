package com.backend.gini.domain.boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findAllByCategory_categoryIdAndDeleteFlag(int categoryId, String deleteFlag, Pageable pageable);
}