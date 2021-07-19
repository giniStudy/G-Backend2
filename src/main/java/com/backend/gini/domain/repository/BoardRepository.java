package com.backend.gini.domain.repository;
import com.backend.gini.domain.posts.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {
    Page<BoardEntity> findAllByCategory_categoryIdAndDeleteFlag(int categoryId, String deleteFlag, Pageable pageable);
}