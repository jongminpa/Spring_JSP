package jspboard.board.jspboard.service;

import jspboard.board.jspboard.repository.BoardRepository;
import jspboard.board.jspboard.zboard.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardServiceTest {

    @Autowired BoardService boardService;
    @Autowired BoardRepository boardRepository;

    @Test
    void 데이터저장() {
        //given
        Board board = new Board();
        board.setClassification("분류");
        board.setContent("내용");
        board.setDivision("division");
        board.setTitle("title");
        board.setUserName("name");
        board.setUserType("type");

        //when
        Long saveId = boardService.boardSave(board);

        //then

        assertEquals(board,boardRepository.findOne(saveId));
    }


}