package com.sesac.sesacspring.jpa.controller;

import com.sesac.sesacspring.jpa.dto.*;
import com.sesac.sesacspring.jpa.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/v1/board")
public class BoardController {
  @Autowired
  BoardService boardService;

  @GetMapping("")
  public String getBoard(Model model){
    List<BoardDTO> result = boardService.getBoard();
    model.addAttribute("list", result);
    return "board2";
  }

  @PostMapping("/create")
  @ResponseBody
  public boolean createBoard(@RequestBody BoardDTO boardDTO){
    boardService.createBoard(boardDTO);
    return true;
  }

  @PatchMapping("")
  @ResponseBody
  public void updateBoard(@RequestBody BoardDTO boardDTO){
    boardService.updateBoard(boardDTO);
  };

  @DeleteMapping("")
  @ResponseBody
  public void deleteBoard(@RequestParam int id) {boardService.deleteBoard(id);}

  @GetMapping("/search")
  @ResponseBody
  public int searchBoard(@RequestParam String word){return boardService.searchBoard(word);}
}
