package com.backend.gini.service;

import com.backend.gini.domain.boards.BoardRepository;
import com.backend.gini.domain.boards.Category;
import com.backend.gini.domain.boards.CategoryRepository;
import com.backend.gini.web.dto.BoardsReuqest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;

    public List<?> getBoards(BoardsReuqest request) {
        Category category = categoryRepository.findByName(request.getCategory())
                                .orElseThrow(()->new RuntimeException()); // TODO exception 재정의
        return boardRepository.findByCategoryAndDeleteFlagFalse(category);
    }

}