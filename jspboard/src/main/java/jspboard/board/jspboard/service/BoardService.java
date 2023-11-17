package jspboard.board.jspboard.service;

import jspboard.board.jspboard.boardDTO.BoardDTO;
import jspboard.board.jspboard.repository.BoardRepository;
import jspboard.board.jspboard.zboard.Board;
import jspboard.board.jspboard.zboard.BoardSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     * 게시글 등록
     * */

    @Transactional
    public Long boardSave(Board board){
//        if(board.getUserName().length() >15){
//            throw new IllegalArgumentException("사용자 이름은 15자를 초과할 수 없습니다.");
//        }
//        if(board.getTitle().length() > 100){
//            throw new IllegalArgumentException("게시물 제목은 100자를 초과할 수 없습니다.");
//        }
        boardRepository.save(board);
        return board.id;
    }

    public List<Board> findBoards(){
        return boardRepository.findAll();
    }
    public Board findOne(Long boardId){
        return boardRepository.findOne(boardId);
    }

    /*
    * 게시글 수정
    * */
    @Transactional
    public void updateBoard(Long id, BoardDTO boardDTO){

        Board board = boardRepository.findOne(id);
        board.setUserName(boardDTO.getUserName());
        board.setTitle(boardDTO.title);
        board.setContent(boardDTO.content);
    }

    /*
    * 게시글 검색
    * */

    public List<Board> findBoards(BoardSearch boardSearch){
        return boardRepository.findBoardS(boardSearch);
    }

    /*
    * 조회수 증가
    * */

    @Transactional
    public void addClick(Long id){
        Board board = boardRepository.findOne(id);
        if(board != null){
            board.setClick(board.getClick() + 1);
        }
    }
}
