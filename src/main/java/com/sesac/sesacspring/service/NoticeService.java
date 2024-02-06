package com.sesac.sesacspring.service;

import com.sesac.sesacspring.domain.*;
import com.sesac.sesacspring.dto.*;
import com.sesac.sesacspring.mapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class NoticeService {

  @Autowired
  NoticeMapper noticeMapper;

  public List<NoticeDTO> getNotice(){
    List<Notice> result = noticeMapper.getNotice();
    List<NoticeDTO> notices = new ArrayList<>();

    for ( Notice notice : result){
      NoticeDTO noticeDTO = new NoticeDTO();
      noticeDTO.setId(notice.getId());
      noticeDTO.setTitle(notice.getTitle());
      noticeDTO.setContent(notice.getContent());
      noticeDTO.setWriter(notice.getWriter());
      noticeDTO.setRegistered(notice.getRegistered());
      noticeDTO.setNo(100 + notice.getId());
      notices.add(noticeDTO);
    }
    return notices;
  }
  public int searchNotice(String word){
    List<Notice> result = noticeMapper.searchNotice(word);
    return result.size();
  }

  public boolean postNoticeInsert(NoticeDTO noticeDTO){
    Notice notice = new Notice();
    notice.setTitle(noticeDTO.getTitle());
    notice.setContent(noticeDTO.getContent());
    notice.setWriter(noticeDTO.getWriter());

    noticeMapper.postNoticeInsert(notice);
    return true;
  }
  public void updateNotice(NoticeDTO noticeDTO){
    Notice notice = new Notice();
    // id와 title 등과 분리해야함
    notice.setId(noticeDTO.getId());
    notice.setTitle(noticeDTO.getTitle());
    notice.setContent(noticeDTO.getContent());
    notice.setWriter(noticeDTO.getWriter());
    noticeMapper.patchNotice(notice);
  }
  public void deleteNotice(int id){noticeMapper.deleteNotice(id);};
}
