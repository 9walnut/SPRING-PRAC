package com.sesac.sesacspring.controller;


import com.sesac.sesacspring.dto.*;
import com.sesac.sesacspring.vo.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

// === GET ===
// 매개변수를 넘겨받는 방법
// 1. /test?id=123 @Requestparam
// 2. /test/123 @PathVariable

@Controller
//@RestController // @Controller + @responsebody
public class MainController {
  @GetMapping("/")
  public String getMain() {
    return "request";
  }

  @GetMapping("/get/response1")
  // ?key=value
  // ?name=
  // @RequestParam 은 required= true 이 기본값
  public String getResponse1(@RequestParam(value = "name") String i, Model model) {
    // 이렇게 설정하면 name 값은 필수로 들어가야함
    // ?id=11&hashtag=112 (이런식은 안된다는 것임)
    model.addAttribute("name", i);
    return "response";
  }

  @GetMapping("/get/response2")
  // ?search = 검색어
  // ?search = 검색어&hashtag=코딩
  // -query string 에서 특정 key 를 옵셔널하게 받아야하는 경우
  // 검색할 때 검색어는 필수, 해시태그는 선택
  public String getResponse2(
          @RequestParam(value = "name", required = false) String name,
          Model model
  ) {
    model.addAttribute("name", name);
    return "response";
  }

  @GetMapping("/get/response3/{param1}/{param2}")
  // url 안에 넣을 때 @PathVariable
  public String getResponse3(
          @PathVariable String param1,
          @PathVariable(value = "param2") String age,
          Model model) {
    model.addAttribute("name", param1);
    model.addAttribute("age", age);
    return "response";
  }

  // 선택적으로 처리한다면 두개의 url을 모두 명시해줘야함
  @GetMapping({"/get/response4/{param1}/{param2}", "/get/response4/{param1}"})
  public String getResponse4(
          @PathVariable String param1,
          @PathVariable(required = false, value = "param2") String age,
          Model model) {
    model.addAttribute("name", param1);
    model.addAttribute("age", age);
    return "response";
  }
  @PostMapping("/post/response1")
  public String postResponse1(
          @RequestParam(value = "name") String a,
          @RequestParam(value = "age") String b,
          Model model
  ) {
    model.addAttribute("name", a);
    model.addAttribute("age",b);
    return "response";
  }

  @PostMapping("/post/response2")
  public String postResponse2(
          @RequestParam(value = "name", required = false) String a,
          @RequestParam(value = "age", required = false) String b,
          Model model
  ) {
    model.addAttribute("name", a);
    model.addAttribute("age",b);
    return "response";
  }

  //@ResponseBody
  // 듣압시 객체를 json 형태로 리턴한다(직렬화)
  // express에서 res.send 와 유사하다고 이해하면됨
  @PostMapping("/post/response3")
  @ResponseBody
  public String postResponse3(
          @RequestParam(value = "name", required = false) String a,
          @RequestParam(value = "age", required = false) String b,
          Model model
  ) {
    model.addAttribute("name", a);
    model.addAttribute("age",b);
    return a + "=-" + b;
  }

  @GetMapping("/introduce/{param1}")
  public String getIntroduce(
          @PathVariable String param1,
          Model model
  ){
    model.addAttribute("name", param1);
    return "response1";
  }

  @GetMapping("/introduce2")
  public String getIntroduce2(
          @RequestParam (value = "name") String name,
          @RequestParam (value = "age") String age,
          Model model
  ){
    model.addAttribute("name", name);
    model.addAttribute("age", age);
    return "response1";
  }

  @PostMapping("/post/response4")
  public String postResponse4(
          @RequestParam(value = "name", required = false) String a,
          @RequestParam(value = "gender", required = false) String b,
          @RequestParam(value = "year", required = false) String year,
          @RequestParam(value = "month", required = false) String month,
          @RequestParam(value = "day", required = false) String day,
          @RequestParam(value = "hobby", required = false) String d,
          Model model
  ) {
    String c = year + "-" + month + "-" + day;

    model.addAttribute("name", a);
    model.addAttribute("gender", b);
    model.addAttribute("birth", c);
    model.addAttribute("hobby", d);

    return "response1";
  }

  @GetMapping("/dto/response1")
  @ResponseBody
  public String dtoResponse1(@ModelAttribute UserDTO userDTO){
    return userDTO.getName() + " " + userDTO.getAge();
  }
//  @ResponseBody : 요청의 본문에 있는 데이틀를 받는 친구
  @GetMapping("/dto/response11")
  @ResponseBody
  public String dtoResponse11(@RequestBody UserDTO userDTO){
    return userDTO.getName() + " " + userDTO.getAge();
  }

  // 일반 폼 전송 >> www-x-form-urlencoded = 쿼리 매개변수
  // 일반 폼 전송 >> RequestBody 값을 받을 수 없음
  // RequestBody는 요청의 본문에 있는 데이터를 처리할 수 있기 때문에
  // json, xml 일 때만 실행이 가능
  // application/json 형태로
  //일반 폼 전송 - DTO getter, setter 모두 있는 친구
  // 1) 어노테이션 없이 DTO로 받을 경우 가능
  // 2) @ModelAttribute DTO 받을 경우
  // 3) @RequestBody DTO 받을 경우 >> 오류

  @GetMapping("/vo/response1")
  @ResponseBody
  public String voResponse1(UserVO userVO){
    return userVO.getName() + " " + userVO.getAge();
  }

  @PostMapping("/vo/response2")
  @ResponseBody
  public String voResponse2(UserVO userVO){
    return userVO.getName() + " " + userVO.getAge();
  }

  @PostMapping("/vo/response3")
  @ResponseBody
  public String voResponse3(@RequestBody UserVO userVO){
    return userVO.getName() + " " + userVO.getAge();
  }

  ///////////// axios 를 이용한 데이터 처리
  @GetMapping("/axios/response1")
  @ResponseBody
  public String axiosResponse1(@RequestParam String name, @RequestParam String age){
    return name + " " + age;
  }// 1. Axios - get - @RequestParam - 가능함

  @GetMapping("/axios/response2")
  @ResponseBody
  public String axiosResponse2(UserDTO userDTO){
    // @ModelAttribute
    // axoise - applcation/json
    return userDTO.getName() + " " + userDTO.getAge();
  } // 2. Axios - get - @ModelAttribute - 가능함


}