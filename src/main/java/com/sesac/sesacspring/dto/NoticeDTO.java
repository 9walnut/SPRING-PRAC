package com.sesac.sesacspring.dto;

import lombok.*;

@Getter
@Setter
public class NoticeDTO {
  private int id;
  private String title;
  private String content;
  private String writer;
  private String registered;
  private int no;
}
