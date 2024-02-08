package com.sesac.sesacspring.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

// 데이터베이스의 필드와 변수의 연관관계가 정의된 친구
// db 테이블에 대응되는 하나의 클래스
@Entity // 클래스 student() {} // 빈 생성자가 필수로 필요
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder // 필드가 전체 들어있는 생성자가 필수 그래서 entity 와 충돌되는 것임
public class Student {
  @Id // pk라는 것을 의미
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private int id;
  // SEQUENCE : 새로운 오브젝트를 만들어서 id를 부여하는 방법 (mysql에서는 전략이 없음)
  // TABLE : SEQUENCE 전략을 흉내낸 전략 >> 모든 DBMS에서 사용 가능

  @Column(name = "name", nullable = false, length = 20)
  private String name;
  // name varchar(20) not null;
  @Column(columnDefinition = "TEXT")
  private String nickname;

  // enum
  @Enumerated(EnumType.STRING)
  private LoginType type;

  public enum LoginType{
    GOOGLE, KAKAO
  }
}
