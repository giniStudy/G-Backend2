package com.backend.gini.service;

import com.backend.gini.domain.entity.BoardEntity;
import com.backend.gini.domain.repository.BoardRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }

    public Page<BoardEntity> getBoards(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public BoardEntity getContent(int bId){
        return boardRepository.findById(bId).orElseThrow(()-> new ResourceNotFoundException("bId"));
    }

    public BoardEntity insertBoard(BoardEntity boardEntity){ return boardRepository.save(boardEntity);}

    public BoardEntity modifyBoard(int bId,BoardEntity boardEntity){
        BoardEntity boardEntityFromDB = boardRepository.findById(bId).orElseThrow(()-> new ResourceNotFoundException("bId"));
        boardEntityFromDB.setTitle(boardEntity.getTitle());
        boardEntityFromDB.setContent(boardEntity.getContent());
        return boardRepository.save(boardEntity);
    }

    public void deleteBoard(int bId){
         boardRepository.deleteById(bId);
    }
}
