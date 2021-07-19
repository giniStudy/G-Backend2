package com.backend.gini.web;
import com.backend.gini.domain.boards.Board;
import com.backend.gini.domain.global.Response;
import com.backend.gini.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
        Page<Board> boards = boardService.getBoards(pageable, categoryId);
        return new ResponseEntity(Response.res(HttpStatus.OK.value(), HttpStatus.OK.toString(), boards), HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 검색")
    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getContent(@PathVariable int boardId){
        Board board = boardService.getContent(boardId);
        return new ResponseEntity<>(board,HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 작성", notes = "<strong>제목(title), 내용(content)</strong>")
    @PostMapping
    public Board insertBoard(@RequestBody Board boardEntity){
        return boardService.insertBoard(boardEntity);
    }

    @ApiOperation(value = "게시글 수정", notes = "<strong>제목(title), 내용(content)</strong>")
    @PatchMapping("/{boardId}")
    public Board modifyBoard(@PathVariable int boardId, @RequestBody Board boardEntity){
        return boardService.modifyBoard(boardId, boardEntity);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/{boardId}")
    public Board deleteBoard(@PathVariable int boardId){
        return boardService.deleteBoard(boardId);
    }
}
