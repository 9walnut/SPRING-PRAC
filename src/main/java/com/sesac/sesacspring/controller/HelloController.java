package com.sesac.sesacspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;


@Controller
public class HelloController {


  @GetMapping("/hi")
  public String getHi(Model model){
    // Model : Controller 안의 메서드가 파라미터로 받을 수 있는 객체 중 하나
    // Model안에 정보를 담아서 View로 전달
    // IoC : 개발자가 직접 모델을 생성하지 않음

    model.addAttribute("name", "홍길동");
    model.addAttribute("name2", "<strong>코딩온</strong>");
    model.addAttribute("age", 17);

    String[] x = {"a", "b", "c", "d", "e"};
    model.addAttribute("item1", x);
    char[] alphabetArray = new char[26];
    char alphabet = 'A';

    for (int i = 0; i < 26; i++) {
      alphabetArray[i] = alphabet;
      alphabet++;
    }
    model.addAttribute("item2", alphabetArray);

    return "hi"; // 템플릿 파일의 이름
    // res.render("hi")
  }

  @GetMapping("/people")
  public String getPeople(Model model){
    ArrayList<Person> people = new ArrayList<>();
    people.add(new Person("kim", 10));
    people.add(new Person("lee", 10));
    people.add(new Person("hong", 10));
    people.add(new Person("park", 10));

    model.addAttribute("people", people);
    return "practice";
  }
}

