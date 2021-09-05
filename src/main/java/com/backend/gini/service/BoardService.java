package com.backend.gini.service;

import com.backend.gini.domain.boards.Board;
import com.backend.gini.domain.boards.BoardRepository;
import com.backend.gini.domain.boards.Category;
import com.backend.gini.domain.boards.CategoryRepository;
import com.backend.gini.web.dto.BoardDto;
import com.backend.gini.web.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    /**
     * <pre>
     *     카테고리 번호로 Board List 반환
     * </pre>
     * */
    public List<?> getBoards(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                                .orElseThrow(()->new RuntimeException()); // TODO exception 재정의
        return boardRepository.findByCategoryAndDeleteFlagFalse(category).stream().map(e->e.toBoardDto()).collect(Collectors.toList());
    }

    public BoardDto createBoard(BoardDto boardDto) {
        Category category = categoryRepository.findById(boardDto.getCategoryId())
                .orElseThrow(()->new RuntimeException()); // TODO exception 재정의
        return boardRepository.save(boardDto.toBoard(category)).toBoardDto();
    }

    public CategoryDto createCategory(CategoryDto categoryDto) {
        return categoryRepository.save(categoryDto.toCategory()).toCategoryDto();
    }

}