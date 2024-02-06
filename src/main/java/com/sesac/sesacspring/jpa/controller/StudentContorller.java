package com.sesac.sesacspring.jpa.controller;

import com.sesac.sesacspring.jpa.dto.*;
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

  @GetMapping("/all")
  public List<StudentDTO> getAll(){
    // student의 목록을 전부 가져와서 보여주는 api
    List<StudentDTO> result = studentService.getStudentAll();
    return result;
  }

//  @GetMapping("/search")
//  public ? getSearch(@RequestBody int id){}
}
