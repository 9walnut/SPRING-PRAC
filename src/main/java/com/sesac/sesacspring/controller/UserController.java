package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.dto.*;
import com.sesac.sesacspring.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/user") //
public class UserController {
  // C, R
  // 1. table 생성 완료
  // 2. domain 만들기 (user)
  // 3. mapper 만들기
  // 4. service 만들기
  // 5. contorller만들기

  @Autowired
  UserService userService;
  @GetMapping("/all") // /user 경로로 인식됨
  public List<UserDTO> getUser(){
    List<UserDTO> result = userService.retrieveAll();
    return result;
  } // []

  @GetMapping("/user")
  public String getUserInsert(@RequestParam String name, @RequestParam String nickname){
    userService.createUser(name, nickname);
    return "Success";
  }

  @GetMapping("/update")
  public void getUserUpdate(@RequestParam int id, @RequestParam String nickname) {
    userService.updateUser(id, nickname);
  }

  @GetMapping("/delete")
  public void getUserDelete(@RequestParam int id){
    userService.deleteUser(id);
  }
}


