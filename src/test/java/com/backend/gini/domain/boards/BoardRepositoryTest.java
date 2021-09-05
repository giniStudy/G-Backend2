package com.backend.gini.domain.boards;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

//    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "본문";

        boardRepository.save(Board.builder().title(title).content(content).build());
        List<Board> boardList = boardRepository.findAll();
        Board board = boardList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
    }
}