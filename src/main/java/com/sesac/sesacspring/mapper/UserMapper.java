package com.sesac.sesacspring.mapper;

import com.sesac.sesacspring.domain.*;
import org.apache.ibatis.annotations.*;

import java.util.*;

@Mapper
public interface UserMapper {
  // sql 문을 정의하거나 xml파일을 읽거나

  // xml 파일을 읽어서 실행하겠다.
  List<User> retrieveAll();

  // sql 문 정의
  @Insert("insert into user(name, nickname) values(#{name}, #{nickname})")
  void createUser(String name, String nickname);

  @Update("update user set nickname=#{nickname} where id=#{id}")
  void updateUser(int id, String nickname);


  @Delete("DELETE FROM user where id=#{id}")
  void deleteUser(int id);
}
