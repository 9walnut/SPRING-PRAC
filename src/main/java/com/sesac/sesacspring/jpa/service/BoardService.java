package com.sesac.sesacspring.jpa.service;

import com.sesac.sesacspring.jpa.dto.*;
import com.sesac.sesacspring.jpa.entity.*;
import com.sesac.sesacspring.jpa.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.time.*;
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
              .id(board.getId())
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
    Board board = boardRepository.findById(boardDTO.getId())
            .orElseThrow(()->new NoSuchElementException("id is wrong"));

    Board updateBoard =
            Board.builder().id(board.getId()).title(boardDTO.getTitle()).content(boardDTO.getContent()).writer(boardDTO.getWriter())
                    .registered(LocalDateTime.now())
                    .build();
    boardRepository.save(updateBoard);
  }

  public void deleteBoard(int id){
    Board board = boardRepository.findById(id)
            .orElseThrow(()->new NoSuchElementException("id is wrong"));
    boardRepository.delete(board)
    ;}

  public int searchBoard(String word){
    List<Board> result = boardRepository.findByTitleContaining(word);
    return result.size();
  }
}
