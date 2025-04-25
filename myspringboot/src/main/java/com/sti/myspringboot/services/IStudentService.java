package com.sti.myspringboot.services;

import com.sti.myspringboot.dto.StudentByCourse;
import com.sti.myspringboot.dto.StudentDto;


import java.util.List;


public interface IStudentService {

    List<StudentByCourse> getAllStudentWithCourse();
    StudentByCourse getAllStudentWithCourseById(Long id);
    StudentByCourse getAllStudentWithCourseByAccountNumber(Long accountNumber);

    List<StudentDto> getStudent();

    void save(StudentDto studentDto);

    void delete(Long id);

}
