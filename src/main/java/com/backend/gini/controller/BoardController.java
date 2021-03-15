package com.backend.gini.controller;

import com.backend.gini.domain.entity.BoardEntity;

import com.backend.gini.service.BoardService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Page<BoardEntity>> getBoards(final Pageable pageable){
        Page<BoardEntity> boards =boardService.getBoards(pageable);
        HttpStatus status = boards.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        return new ResponseEntity<Page<BoardEntity>>(boards, status);
    }

    @GetMapping("/{bId}")
    public ResponseEntity<BoardEntity> getContent(@PathVariable int bId){
        BoardEntity board = boardService.getContent(bId);
        return new ResponseEntity<>(board,HttpStatus.OK);
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
}
