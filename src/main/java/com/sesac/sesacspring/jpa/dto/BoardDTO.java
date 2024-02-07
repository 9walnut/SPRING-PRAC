package com.sesac.sesacspring.jpa.dto;

import lombok.*;

import java.time.*;

@Builder
@Getter
public class BoardDTO {
  private int id;
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;
  private int no;
}
