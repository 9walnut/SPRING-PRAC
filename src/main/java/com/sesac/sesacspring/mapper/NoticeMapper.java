package com.sesac.sesacspring.mapper;

import com.sesac.sesacspring.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface NoticeMapper {
  List<Notice> retrieveAll();
  @Select("select * from notice")
  List<Notice> getNotice();
  @Select("SELECT * FROM notice WHERE title LIKE '%${word}%'")
  List<Notice> searchNotice(String word);
  @Insert("insert into notice(title, content, writer) values(#{title}, #{content}, #{writer})")
  void postNoticeInsert(String title, String content, String writer);

  @Update("update notice set title=#{title}, content=#{content}, writer=#{writer} where id=#{id}")
  void updateNotice(int id, String title, String content, String writer);

  @Delete("delete from notice where id=#{id}")
  void deleteNotice(int id);

}
