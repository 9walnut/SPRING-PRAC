package com.sesac.sesacspring.jpa.service;

import com.sesac.sesacspring.jpa.dto.*;
import com.sesac.sesacspring.jpa.entity.*;
import com.sesac.sesacspring.jpa.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BoardService {
  @Autowired
  BoardRepository boardRepository;

  public List<BoardDTO> getBoard(){
    List<Board> result = boardRepository.findAll();
    List<BoardDTO> boards = new ArrayList<>();

    for (Board board : result){
      BoardDTO boardDTO = BoardDTO.builder()
              .title(board.getTitle())
              .content(board.getContent())
              .writer(board.getWriter())
              .registered(board.getRegistered())
              .no(100+board.getId())
              .build();
      boards.add(boardDTO);
    }
    return boards;
  }

  public boolean createBoard(BoardDTO boardDTO){
    Board board = Board.builder()
            .title(boardDTO.getTitle())
            .content(boardDTO.getContent())
            .writer(boardDTO.getWriter())
            .build();
    boardRepository.save(board);
    return true;
  }
  public void updateBoard(BoardDTO boardDTO) {
    Optional<Board> optionalBoard = boardRepository.findById(boardDTO.getId());

    if (optionalBoard.isPresent()) {
      Board board = optionalBoard.get();
      board.update(boardDTO);
      boardRepository.save(board);
    } else {
      throw new NoSuchElementException("찾고자 하는 게시글이 없습니다.");
    }
  }

  public void deleteBoard(int id){boardRepository.deleteById(id);}

  public int searchBoard(String word){
    List<Board> result = boardRepository.findByTitleContaining(word);
    return result.size();
  }
}
