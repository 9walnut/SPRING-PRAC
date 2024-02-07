package com.sesac.sesacspring.jpa.dto;

import java.time.LocalDateTime;

public class BoardDTOBuilder {
  private String title;
  private String content;
  private String writer;
  private LocalDateTime registered;

  public static class Builder{
    private String title;
    private String content;
    private String writer;

    public Builder title(String title){
      this.title = title;
      return this;
    }
    public Builder content(String content){
      this.content = content;
      return this;
    }
    public Builder writer(String writer){
      this.writer = writer;
      return this;
    }
    public BoardDTOBuilder build(){return new BoardDTOBuilder(title, content, writer);}
  }

  public BoardDTOBuilder(String title, String content, String writer){
    this.title = title;
    this.content = content;
    this.writer = writer;
  }
  public static Builder builder(){return new Builder();}
}
