package com.sti.myspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String accountNumber;


    private LocalDate createAt;

    private LocalDate lastUpdate;

    // n+1 lazy
   // @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
   // private List<Course> courses;

    @OneToMany(mappedBy = "student")
    private List<CourseRating> ratings;

}
