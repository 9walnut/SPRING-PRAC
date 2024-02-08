package com.sesac.sesacspring.jpa.controller;

import com.sesac.sesacspring.jpa.dto.*;
import com.sesac.sesacspring.jpa.entity.*;
import com.sesac.sesacspring.jpa.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/student")
public class StudentContorller {
  @Autowired
  StudentService studentService;
//  @GetMapping("/count")
//  public int getCountAll(){}

  //  1. 전체 검색(select * from student
  @GetMapping("/all")
  public List<StudentDTO> getAll() {
    // student의 목록을 전부 가져와서 보여주는 api
    List<StudentDTO> result = studentService.getStudentAll();
    return result;
  }

  //  2. 삽입 (insert into ~~~)
  @GetMapping("/insert")
  public String insertStudent(@RequestParam String name,
                              @RequestParam String nickname,
                              @RequestParam Student.LoginType type) {
    return studentService.insertStudent(name, nickname, type);
    // 이름, 닉네임, login_type
  }

  //  3. 조건에 따른 검색 (select * from student where name="")
  @GetMapping("/search/name")
  public String searchStudentByName(@RequestParam String name) {
    return studentService.searchStudentByName(name);
  }

  //  4. 조건에 따른 검색 (2) (select * from student where id=)
  @GetMapping("/search/id")
  public String searchStudentByID(@RequestParam int id) {
    return studentService.searchStudentById(id);
  }


//  @GetMapping("/search")
//  public ? getSearch(@RequestBody int id){}

  @GetMapping("/count")
  public int countStudent(@RequestParam String nickname) {
    return studentService.countStudentByNickname(nickname);
  }

  @GetMapping("/update")
  public String updateStudent(@RequestParam int id,
                              @RequestParam String name){
    return studentService.updateStudent(id, name);
  }
}
