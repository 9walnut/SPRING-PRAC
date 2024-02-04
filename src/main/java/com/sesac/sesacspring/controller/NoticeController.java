package com.sesac.sesacspring.controller;

import com.sesac.sesacspring.domain.*;
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
  @GetMapping("")
  public String getNotice(Model model){
    List<Notice> noticeList = noticeService.getNotice();
    model.addAttribute("noticeList", noticeList);
    return "board";
  }


//  @GetMapping("/all")
//  public List<NoticeDTO> getNotice(){
//    List<NoticeDTO> result = noticeService.retrieveAll();
//    return result;
//  }

  @GetMapping("/search")
  @ResponseBody
  public int getNoticeSearch(@RequestParam String word){
    List<Notice> result =  noticeService.searchNotice(word);
    return result.size();
  }

//  글 작성
  @PostMapping("/create")
  @ResponseBody
  public void createNotice(@RequestBody NoticeDTO notice){
    noticeService.postNoticeInsert(notice.getTitle(), notice.getContent(), notice.getWriter());
  }
// 글 수정
  @PatchMapping("")
  public void patchNoticeUpdate(@RequestBody Notice notice){
    noticeService.updateNotice(notice.getId(), notice.getTitle(), notice.getContent(), notice.getWriter());
  }

//  글 삭제
  @DeleteMapping("")
  public void deleteNotice(@RequestParam int id){
    noticeService.deleteNotice(id);
  }
}
