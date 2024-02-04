package com.sesac.sesacspring.service;

import com.sesac.sesacspring.domain.*;
import com.sesac.sesacspring.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class NoticeService {

  @Autowired
  NoticeMapper noticeMapper;

  public List<Notice> getNotice(){
    List<Notice> result = noticeMapper.getNotice();
    return result;
  }
  public List<Notice> searchNotice(String word){
    List<Notice> result = noticeMapper.searchNotice(word);
    return result;
  }

  public void postNoticeInsert(String title, String content, String writer){noticeMapper.postNoticeInsert(title, content, writer);}
  public void updateNotice(int id, String title, String content, String writer){noticeMapper.updateNotice(id, title, content, writer);}
  public void deleteNotice(int id){noticeMapper.deleteNotice(id);};
}
