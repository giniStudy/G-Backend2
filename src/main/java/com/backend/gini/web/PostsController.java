package com.backend.gini.web;
import com.backend.gini.service.BoardService;

import com.backend.gini.web.dto.BoardDto;
import com.backend.gini.web.dto.CategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api
@Slf4j
@RequestMapping("/api/posts")
@RequiredArgsConstructor
@RestController
public class PostsController {

    private final BoardService boardService;

    @ApiOperation(
            value = "게시글 목록 검색",
            notes = "")
    @ApiImplicitParam(
            name = "categoryId",
            value = "카테고리 id",
            required = true,
            dataType = "string",
            paramType = "path",
            defaultValue = "None"
    )
    @GetMapping({"/board/{categoryId}"})
    public ResponseEntity<?> getBoards( @PathVariable Long categoryId){
        return ResponseEntity.ok(boardService.getBoards(categoryId));
    }

    @ApiOperation(value = "board 추가",
            notes = "categoryId -> category_id 이거로 보내야 됩니다")
    @PostMapping("/board")
    public ResponseEntity<?> postBoard(@RequestBody BoardDto boardDto){
        System.out.println(boardDto.toString());

        return ResponseEntity.ok(boardService.createBoard(boardDto));
    }

    @ApiOperation(value = "category 추가")
    @PostMapping("/category")
    public ResponseEntity<?> postCategory(@RequestBody CategoryDto boardDto){
        return ResponseEntity.ok(boardService.createCategory(boardDto));
    }

    @ApiOperation(value = "category 조회")
    @GetMapping("/category")
    public ResponseEntity<?> getCategory(){
        return ResponseEntity.ok(boardService.getCategorys());
    }

    /*
    private final BoardService boardService;



    @ApiOperation(value = "게시글 검색")
    @GetMapping("/{boardId}")
    public ResponseEntity<Board> getContent(@PathVariable int boardId){
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "게시글 작성", notes = "<strong>제목(title), 내용(content)</strong>")
    @PostMapping
    public ResponseEntity<Board> insertBoard(@RequestBody Board boardEntity){
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "게시글 수정", notes = "<strong>제목(title), 내용(content)</strong>")
    @PatchMapping("/{boardId}")
    public ResponseEntity<Board> modifyBoard(@PathVariable int boardId, @RequestBody Board boardEntity){
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "게시글 삭제")
    @DeleteMapping("/{boardId}")
    public ResponseEntity<Board> deleteBoard(@PathVariable int boardId){
        return ResponseEntity.ok(null);
    }
    */
}
