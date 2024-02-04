package com.sesac.sesacspring.domain;

import lombok.*;

@Getter
@Setter
public class Notice {
  private int id;
  private String title;
  private String content;
  private String writer;
  private String registered;
}
