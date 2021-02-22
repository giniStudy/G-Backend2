package com.backend.gini.service;

import com.backend.gini.domain.entity.BoardEntity;
import com.backend.gini.domain.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public List<BoardEntity> getAllBoard(){
        return boardRepository.findAll();
    }

    public Page<BoardEntity> getBoard(Pageable pageable){
        return boardRepository.findAll(pageable);
    }
}
