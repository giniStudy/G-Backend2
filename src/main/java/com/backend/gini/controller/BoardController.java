package com.backend.gini.controller;

import com.backend.gini.domain.entity.BoardEntity;

import com.backend.gini.service.BoardService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    public Page<BoardEntity> getBoards(final Pageable pageable){
        return boardService.getBoards(pageable);
    }

    @GetMapping("/{bId}")
    public BoardEntity getContent(@PathVariable int bId){
        return boardService.getContent(bId);
    }

    @ApiImplicitParams({
        @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
        @ApiImplicitParam(name = "content", value = "내용", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @PostMapping
    public BoardEntity insertBoard( @RequestBody BoardEntity boardEntity){
        return boardService.insertBoard(boardEntity);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "bId", value = "번호", required = true, dataType = "string", paramType = "path", defaultValue = ""),
            @ApiImplicitParam(name = "title", value = "제목", required = true, dataType = "string", paramType = "query", defaultValue = ""),
            @ApiImplicitParam(name = "content", value = "내용", required = true, dataType = "string", paramType = "query", defaultValue = ""),
    })
    @PatchMapping("/{bId}")
    public BoardEntity modifyBoard(@PathVariable int bId, @RequestBody BoardEntity boardEntity){
        return boardService.modifyBoard(bId, boardEntity);
    }

    @ApiImplicitParam(name = "bId", value = "번호", required = true, dataType = "string", paramType = "path", defaultValue = "")
    @DeleteMapping("/{bId}")
    public void deleteBoard(@PathVariable int bId){
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
