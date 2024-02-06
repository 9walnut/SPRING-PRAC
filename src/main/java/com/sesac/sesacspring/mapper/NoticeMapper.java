package com.sesac.sesacspring.mapper;

import com.sesac.sesacspring.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface NoticeMapper {
  // 리더님 버전
  List<Notice> getNotice(); // 전체 조회
  void postNoticeInsert(Notice notice); //  삽입
  void patchNotice(Notice notice);
  void deleteNotice(int id);
  List<Notice> searchNotice(String word);
  
  
//  @Select("SELECT * FROM notice WHERE title LIKE '%${word}%'")
//  List<Notice> searchNotice(String word);

//  
//  @Insert("insert into notice(title, content, writer) values(#{title}, #{content}, #{writer})")
//  void postNoticeInsert(String title, String content, String writer);

//  @Update("update notice set title=#{title}, content=#{content}, writer=#{writer} where id=#{id}")
//  void updateNotice(int id, String title, String content, String writer);

//  @Delete("delete from notice where id=#{id}")
//  void deleteNotice(int id);
}
