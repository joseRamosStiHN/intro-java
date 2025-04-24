package com.sti.myspringboot.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
public class CourseDto {

    private Long id;
    private String name;

    private LocalTime time;
    private int capacity;

}
