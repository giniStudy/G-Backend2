package com.backend.gini.service;

import com.backend.gini.web.BoardController;
import com.backend.gini.domain.boards.Board;
import com.backend.gini.domain.boards.BoardRepository;
import com.backend.gini.domain.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final CategoryRepository categoryRepository;
    private final Logger log = LoggerFactory.getLogger(BoardController.class);

    public BoardService(BoardRepository boardRepository, CategoryRepository categoryRepository){
        this.boardRepository = boardRepository;
        this.categoryRepository = categoryRepository;
    }

    public Page<Board> getBoards(Pageable pageable, Integer categoryId){
        return categoryId == null ? boardRepository.findAll(pageable) : boardRepository.findAllByCategory_categoryIdAndDeleteFlag(categoryId,"N" ,pageable);
    }

    public Board getContent(int boardId){
        return boardRepository.findById(boardId).orElseThrow(()-> new ResourceNotFoundException("boardId"));
    }

    public Board insertBoard(Board boardEntity){
        return boardRepository.save(boardEntity);
    }

    public Board modifyBoard(int boardId, Board boardEntity){
        Board boardEntityFromDB = boardRepository.findById(boardId).orElseThrow(()-> new ResourceNotFoundException("boardId"));

        boardEntityFromDB.setTitle(boardEntity.getTitle());
        boardEntityFromDB.setContent(boardEntity.getContent());
        return boardRepository.save(boardEntityFromDB);
    }

    public Board deleteBoard(int boardId){
        Board boardEntityFromDB = boardRepository.findById(boardId).orElseThrow(()-> new ResourceNotFoundException("boardId"));
        boardEntityFromDB.setDeleteFlag("Y");
        return boardRepository.save(boardEntityFromDB);
    }
}