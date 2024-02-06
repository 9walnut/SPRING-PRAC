package com.sesac.sesacspring.jpa.service;

import com.sesac.sesacspring.jpa.dto.*;
import com.sesac.sesacspring.jpa.entity.*;
import com.sesac.sesacspring.jpa.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class StudentService {
  @Autowired
  StudentRepository studentRepository;
  
  public List<StudentDTO> getStudentAll(){
    List<Student> result = studentRepository.findAll();
    List<StudentDTO> students = new ArrayList<>();
    
    for ( Student student: result){
      // Builder : 객체를 만들 때 순서에 의해 생기는 문제,
      //           명시적이지 못한 문제를 해결하기 위해 나온 방법
      // 생성자 주입 : 여러 개의 필드가 있을 때 순서를 지켜줘야 한다
      // setter : 필드 개수만큼 매번 메서드를 만들어줘야한다.
      StudentDTO studentDTO = StudentDTO.builder()
              .name(student.getName())
              .nickname(student.getNickname())
              .build();
      // StudentDTO studentDTO = new StudentDTO();
      // studentDTO.setName("이름"........
      students.add(studentDTO);

    }
    return students;
  }
}
