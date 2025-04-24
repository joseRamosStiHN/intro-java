package com.sti.myspringboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentByCourse extends StudentDto{

    private List<CourseDto> course;
}
