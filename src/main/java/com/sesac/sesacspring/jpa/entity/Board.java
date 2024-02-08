package com.sesac.sesacspring.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Board {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "title", nullable = false, length = 20)
  private String title;

  @Column(name = "content", nullable = false, length = 20)
  private String content;

  @Column(name = "writer", nullable = false, length = 20)
  private String  writer;

  @Column(name = "registered", nullable = false)
  private LocalDateTime registered;

  @PrePersist
  public void prePersist() {
    this.registered = LocalDateTime.now();  // 저장되기 전에 현재 시간을 설정
  }

  @PreUpdate
  public void preUpdate() {
    this.registered = LocalDateTime.now();  // 업데이트되기 전에 현재 시간을 설정
  }

}
