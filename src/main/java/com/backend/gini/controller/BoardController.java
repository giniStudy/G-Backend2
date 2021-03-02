package com.backend.gini.controller;

import com.backend.gini.domain.entity.BoardEntity;

import com.backend.gini.service.BoardService;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    private final Logger log = LoggerFactory.getLogger(BoardController.class);

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @GetMapping
    public Page<BoardEntity> getBoard(final Pageable pageable){
        return boardService.getBoard(pageable);
    }

    @PostMapping
    public BoardEntity insertBoard(@RequestBody BoardEntity boardEntity){
        return boardService.insertBoard(boardEntity);
    }

    @PutMapping
    public BoardEntity modifyBoard(@RequestBody BoardEntity boardEntity){
        return boardService.modifyBoard(boardEntity);
    }

    @DeleteMapping
    public void deleteBoard(@PathVariable Long bId){
         boardService.deleteBoard(bId);
    }







    //    BID INT UNSIGNED NOT NULL AUTO_INCREMENT,
//    WRITER VARCHAR(20),
//    TITLE VARCHAR(50),
//    CONTENT VARCHAR(2000),
//    DEL_FLAG VARCHAR(1) DEFAULT 'N',
//    UPDATE_USER VARCHAR(20),
//    UPDATE_DATE timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
//    REG_DATE TIMESTAMP DEFAULT NOW(),



}
