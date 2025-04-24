package com.sti.myspringboot.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//
//@Entity
//@Getter
//@Setter
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    int grade;
}
