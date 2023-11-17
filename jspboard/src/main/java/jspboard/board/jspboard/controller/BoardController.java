package jspboard.board.jspboard.controller;

import jspboard.board.jspboard.service.BoardService;
import jspboard.board.jspboard.site.BoardForm;
import jspboard.board.jspboard.zboard.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/")
    public String home(Model model){
        List<Board> boardList = boardService.findBoards();
        model.addAttribute("boards", boardList);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("form",new BoardForm());
        return "/boardcreate/create";
    }
    @PostMapping("/create")
    public String boardCreate(@ModelAttribute BoardForm form){

        Board board = new Board();
        board.setDivision(form.getDivision());
        board.setUserName(form.getUsername());
        board.setUserType(form.getUsertype());
        board.setClassification(form.getClassification());
        board.setTitle(form.getTitle());
        board.setContent(form.getContent());
        board.setFilePath(form.getPath());
        boardService.boardSave(board);

        return "redirect:/";
    }

    @GetMapping("/board/{boardId}/show")
    public String show(@PathVariable("boardId") Long boardId, Model model){

        boardService.addClick(boardId);
        Board board = boardService.findOne(boardId);
        BoardForm form = new BoardForm();
        form.setDivision(board.getDivision());
        form.setId(board.getId());
        form.setUsername(board.getUserName());
        form.setClassification(board.getClassification());
        form.setUsertype(board.getUserType());
        form.setTitle(board.getTitle());
        form.setContent(board.getContent());
        form.setPath(board.getFilePath());
        model.addAttribute("form", form);
        return "/boardshow/show";
    }


    @GetMapping("/edit/{itemId}")
    public String update(){
        return"/boardupdate/edit";
    }


}
