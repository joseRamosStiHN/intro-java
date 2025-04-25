package com.sti.myspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    public Student(String fistName, String lastName, String yearOfEnrollment, LocalDate dayOfBirth, Long accountNumber) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.yearOfEnrollment = yearOfEnrollment;
        this.dayOfBirth = dayOfBirth;
        this.accountNumber = accountNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fistName;
    private String lastName;
    private String yearOfEnrollment;
    private LocalDate dayOfBirth;
    private Long accountNumber;

    @CreationTimestamp
    private LocalDate createAt;
    @UpdateTimestamp
    private LocalDate lastUpdate;

    // n+1 lazy
   // @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = false)
   // private List<Course> courses;
    // Lazy -> se hace el query
    //eager -> se hace el query desde el inicio
    @OneToMany(mappedBy = "student")
    private List<CourseRating> ratings;

}
