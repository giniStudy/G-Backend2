package com.backend.gini.service;

import com.backend.gini.controller.BoardController;
import com.backend.gini.domain.entity.BoardEntity;
import com.backend.gini.domain.repository.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final Logger log = LoggerFactory.getLogger(BoardController.class);

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Page<BoardEntity> getBoards(Pageable pageable, int cIdx){
        return cIdx == 0 ? boardRepository.findAll(pageable) : boardRepository.findAllByCategory_cIdx(cIdx, pageable);
    }

    public BoardEntity getContent(int bIdx){
        return boardRepository.findById(bIdx).orElseThrow(()-> new ResourceNotFoundException("bIdx"));
    }

    public BoardEntity insertBoard(BoardEntity boardEntity){ return boardRepository.save(boardEntity);}

    public BoardEntity modifyBoard(int bIdx,BoardEntity boardEntity){
        BoardEntity boardEntityFromDB = boardRepository.findById(bIdx).orElseThrow(()-> new ResourceNotFoundException("bIdx"));
        boardEntityFromDB.setTitle(boardEntity.getTitle());
        boardEntityFromDB.setContent(boardEntity.getContent());
        return boardRepository.save(boardEntity);
    }

    public void deleteBoard(int bIdx){
        boardRepository.deleteById(bIdx);
    }
}