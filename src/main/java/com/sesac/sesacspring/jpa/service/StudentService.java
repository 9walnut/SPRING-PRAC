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

  public String insertStudent(String name, String nickname, Student.LoginType type){
    // 받아온 데이터로 repository의 save 메서드를 호출
    Student student = Student.builder().name(name).nickname(nickname).type(type).build();
    Student newStudent = studentRepository.save(student);
    // newStudent : save를 한 후 반환되는 Entity 객체

    return newStudent.getId() + newStudent.getName();
  }

  public String searchStudentByName(String name){
    List<Student> student = studentRepository.findByName(name);
    return "해당하는 이름의 사용자는" + student.size() + "명입니다";
  }



  public String searchStudentById(int id){

    Student student = studentRepository.findById(id).orElseThrow(()->new RuntimeException("사용자가 없다!"));
    return student.getName();

//    Optional<Student> student = studentRepository.findById(id);
//    if(student.isPresent()){
//      // isPresent : 객체의 여부를 boolean 으로 변환
//      return student.get().getName();
//      // get : Optional 에 담긴 객체를 반환
//    }
//    return "null";
    // Optional<T> : java8부터 등장한 친구
    // null 일 수도 있느 객체를 감싸는 wrapper 클래스
  }
  public int countStudentByNickname(String nickname){
    return studentRepository.countByNickname(nickname);
  }

//  public String updateStudent(int id, String name){
//    if(studentRepository.findById(id).isEmpty()){
//      return "존재하비 않음";
//    } else{
//      studentRepository.save(Student.builder().id(id).name(name).build());
//      return "변경";
//    }
//  }

  public String updateStudent(int id, String name){
    // save(T) : 새로운 entitiy 삽입 또는 업데이트가 가능함
    // T의 기본값의 상태에 따라 다르게 동작
    // - pk값이 존재하는 경우 pk와 연결된 entity를 update
    // - pk값이 없는 경우 새로운 entity를 insert
    Student student = studentRepository.findById(id)
            .orElseThrow(()->new NoSuchElementException("id is wrong"));
    Student modifiedStudent =
            Student.builder()
            .id(id).name(name).nickname(student.getNickname())
            .type(student.getType())
            .build();
    studentRepository.save(modifiedStudent);
    return "update success";
  }
}
