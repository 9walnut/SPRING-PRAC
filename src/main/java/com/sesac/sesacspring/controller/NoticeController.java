package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.dto.*;
import com.sesac.sesacspring.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/board")
public class NoticeController {
  @Autowired
  NoticeService noticeService;
  // 전체 조회
  @GetMapping("")
  public String getNotice(Model model){
    List<NoticeDTO> result = noticeService.getNotice();
    model.addAttribute("list", result);
    return "board";
  }

//  @GetMapping("/search")
//  @ResponseBody
//  public int getNoticeSearch(@RequestParam String word){
//    List<Notice> result =  noticeService.searchNotice(word);
//    return result.size();
//  }

//  글 작성
  // 동적폼 , post
  @PostMapping("/create")
  @ResponseBody
  public boolean createNotice(@RequestBody NoticeDTO noticeDTO){
    noticeService.postNoticeInsert(noticeDTO);
    return true;
  }
// 글 수정
// 동적폼 , patch
  @PatchMapping("")
  @ResponseBody
  public void patchNoticeUpdate(@RequestBody NoticeDTO noticeDTO){
    noticeService.updateNotice(noticeDTO);
  }

//  글 삭제
// 동적폼 , delete
  @DeleteMapping("")
  @ResponseBody
  public void deleteNotice(@RequestParam int id){
    noticeService.deleteNotice(id);
  }

  @GetMapping("/search")
  @ResponseBody
  public int searchNotice(@RequestParam String word){
    return noticeService.searchNotice(word);
  }
}
