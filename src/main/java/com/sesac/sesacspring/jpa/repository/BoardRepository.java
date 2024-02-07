package com.sesac.sesacspring.jpa.repository;

import com.sesac.sesacspring.jpa.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
  List<Board> findByTitleContaining(String word);
}
