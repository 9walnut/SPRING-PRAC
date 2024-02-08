package com.sesac.sesacspring.jpa.repository;

import com.sesac.sesacspring.jpa.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
// JpaRepository <대상으로 지정할 엔티티, 해당 엔티티의 pk 타입>
public interface StudentRepository extends JpaRepository<Student, Integer> {
  // 1. jpa의 기본 규칙을 따르는 방법
//  findBy 컬럼명
  List<Student> findByName(String name);
  // 아래와 같이 사용할 수 있음
  List<Student> findByNameAndNickname(String name, String nickname);
  List<Student> findByNameOrNickname(String name, String nickname);
  // findByAgeGreaterThanEqual(int age) // age가 값보다 크거나 같은 경우


  // 2. 직접 쿼리를 작성하는 방법
//  @Query("select *s from Student where s.name = :a")
  @Query(nativeQuery = true,value= "select * from student where name= :a")
  List<Student> findTest(String a);

  int countByNickname(String nickname);
}
