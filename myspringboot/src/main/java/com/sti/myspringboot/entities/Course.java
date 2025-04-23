package com.sti.myspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "student_id")
//    private Student student;


    @OneToMany(mappedBy = "course")
    private List<CourseRating> ratings;
}
