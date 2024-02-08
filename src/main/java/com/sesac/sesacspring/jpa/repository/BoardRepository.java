package com.sesac.sesacspring.jpa.repository;

import com.sesac.sesacspring.jpa.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {

  // title이 일치하거나 검색어가 비어있음
  @Query("select b from Board b where (b.title=:word or :word = '')")
  List<Board> findByTitleContaining(String word);
}
