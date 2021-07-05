package com.backend.gini.controller;
import com.backend.gini.domain.entity.BoardEntity;
import com.backend.gini.domain.global.Response;
import com.backend.gini.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@Slf4j
@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @ApiOperation(value = "게시글 목록 검색", notes = "<strong>카테고리번호(category_id) -> 없으면 전체검색</strong>")
    @GetMapping
    public ResponseEntity getBoards(final Pageable pageable, Integer categoryId){
        Page<BoardEntity> boards = boardService.getBoards(pageable, categoryId);
        return new ResponseEntity(Response.res(HttpStatus.OK.value(), HttpStatus.OK.toString(), boards), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 검색")
    @GetMapping("/{boardId}")
    public ResponseEntity<BoardEntity> getContent(@PathVariable int boardId){
        BoardEntity board = boardService.getContent(boardId);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 작성", notes = "<strong>제목(title), 내용(content)</strong>")
    @PostMapping
    public BoardEntity insertBoard( @RequestBody BoardEntity boardEntity){
        return boardService.insertBoard(boardEntity);
    }

    @ApiOperation(value = "게시글 수정", notes = "<strong>제목(title), 내용(content)</strong>")
    @PatchMapping("/{boardId}")
    public BoardEntity modifyBoard(@PathVariable int boardId, @RequestBody BoardEntity boardEntity){
        return boardService.modifyBoard(boardId, boardEntity);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/{boardId}")
    public BoardEntity deleteBoard(@PathVariable int boardId){
        return boardService.deleteBoard(boardId);
    }
}
